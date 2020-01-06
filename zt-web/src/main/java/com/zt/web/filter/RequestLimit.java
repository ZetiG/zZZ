package com.zt.web.filter;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Description: 对高频IP访问限制
 *
 * @Date 2020-01-06 23:14
 * @Author Zeti
 */
@Api(value = "/v2", tags = "高频ip限制接口")
@RestController
@RequestMapping("/v2")
public class RequestLimit {

    /**
     * 对高频ip限制
     *
     * @param request
     * @return
     */
    @ApiOperation(value = "对高频请求IP增加限制", code = 5001, httpMethod = "GET")
    @RequestMapping("/error/requestLimit")
    public Object requestLimitTime(HttpServletRequest request) {
        Object limitTime = request.getAttribute("remainingTime");
        return "IP已被限制，请稍后在试~" + limitTime;
    }

    /**
     * 解除限制
     *
     * @param ip
     * @return
     */
    @ApiOperation(value = "解除被封禁的IP", httpMethod = "GET", notes = "传入被限制IP")
    @RequestMapping("/relieve")
    public Object relieverLimitIp(String ip) {
        if (null != ip) {
            IPFilter filter = new IPFilter();
            Map<String, Long> map = filter.limitedIpMap;
            boolean isLimit = filter.isLimitedIP(map, ip);
            if (isLimit) {
                map.remove(ip);
                return "IP已解禁";
            }
        }
        return "IP不存在或不受限";
    }
}
