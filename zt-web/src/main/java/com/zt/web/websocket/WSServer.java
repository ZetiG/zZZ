package com.zt.web.websocket;

/**
 * Description: ${TODO}(用一句话描述该文件做什么)
 *
 * @Date 2020-01-06 23:00
 * @Author Zeti
 */

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * WebSocket服务
 */
@ServerEndpoint(value = "/v2/chat", configurator = HttpSessionConfigurator.class)
@Component
public class WSServer {

    private static final Logger logger = LoggerFactory.getLogger(WSServer.class);

    //在线人数
    private static int onlineCount = 0;

    //链接集合 userId => server 键值对  线程安全
    private static final ConcurrentMap<String, WSServer> map = new ConcurrentHashMap<>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        //得到HttpSession
        HttpSession httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());

//        ApiUserEntity user = (ApiUserEntity) this.httpSession.getAttribute("user");

        Object object = httpSession.getAttribute("enterprise");
        String code = null;
        if (object != null) {
            // TODO: 2020-01-06
        }
        this.session = session;
        //针对一个用户只能有一个链接
        if (code != null && map.get(code) != null) {
            //移除链接
            map.remove(code);
            //连接数-1
            subOnlineCount();
        }
        if (code != null) {
            //将连接session 对象存入map
            map.putIfAbsent(code, this);
            //链接数+1
            addOnlineCount();
            logger.info("有新的连接，当前连接数为：" + getOnlineCount());
        }
    }


    /**
     * <p>{@link OnClose} 关闭连接</p>
     */
    @OnClose
    public void onClose() {

        // 移除连接
        map.remove(this);

        // 连接数-1
        subOnlineCount();

        logger.info("有一连接断开，当前连接数为：" + getOnlineCount());
    }


    /**
     * <p>{@link OnMessage} 消息监听处理方法</p>
     *
     * @param message 消息对象
     * @throws IOException 异常
     * @Param session 可选参数
     */
    @OnMessage
    public void onMessage(String message) {
        try {
            session.getBasicRemote().sendText(message);
            logger.info("收到心跳,并返回心跳" + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * <p>{@link OnError} websocket系统异常处理</p>
     *
     * @param error 异常
     */
    @OnError
    public void onError(Throwable error) {
        logger.error(String.valueOf(error));
        error.printStackTrace();
    }


    /**
     * 自定义消息推送
     *
     * @param msg
     */
    public static boolean sendMessage(String msg) {
        try {
            WSServer ws = map.get(msg);
            if (ws != null) {
                ws.session.getBasicRemote().sendText(JSON.toJSONString(msg));
                logger.info("消息发送成功给=>" + msg);
                return true;
            }
            logger.error("消息发送失败," + msg + "用户不在线！");
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 获取连接数
    private static synchronized int getOnlineCount() {
        return WSServer.onlineCount;
    }

    // 增加连接数
    private static synchronized void addOnlineCount() {
        WSServer.onlineCount++;
    }

    // 减少连接数
    private static synchronized void subOnlineCount() {
        if (onlineCount > 0) {
            WSServer.onlineCount--;
        }
    }

}

