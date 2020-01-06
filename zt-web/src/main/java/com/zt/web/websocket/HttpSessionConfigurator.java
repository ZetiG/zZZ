package com.zt.web.websocket;

import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

/**
 * Description: ${TODO}(用一句话描述该文件做什么)
 *
 * @Date 2020-01-06 22:56
 * @Author Zeti
 */
@Configuration
public class HttpSessionConfigurator extends ServerEndpointConfig.Configurator {

    @Override
    public void modifyHandshake(ServerEndpointConfig sec,
                                HandshakeRequest request,
                                HandshakeResponse response) {
        //获取当前链接的HttpSession
        HttpSession httpSession = (HttpSession) request.getHttpSession();
        //将HttpSession信息注入到WebSocketSession中
        sec.getUserProperties().put(HttpSession.class.getName(), httpSession);
    }
}