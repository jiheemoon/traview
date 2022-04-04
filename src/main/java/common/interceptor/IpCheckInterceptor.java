package common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.net.util.SubnetUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 사용자IP 체크 인터셉터
 */
public class IpCheckInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(IpCheckInterceptor.class);

    @Value("${Globals.ClientIp.Allowed}")
    private String clientIpAllowed;
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String[] ipAllowArr = clientIpAllowed.split(",");
        String clientIp = getClinetIp(request);

        SubnetUtils subnetUtils = null;
        
        for(String ipAllow : ipAllowArr) {
            if (ipAllow.equals("127.0.0.1")) {
            // 로컬서버 접근 허용  
                return true;
            } else { 
                subnetUtils = new SubnetUtils(ipAllow); 
                subnetUtils.setInclusiveHostCount(true); // network,broadcast ip 포함, false:불포함 
                if (subnetUtils.getInfo().isInRange(clientIp)) { // 허용된 IP만 true 반환
                    logger.info("Access IP " + subnetUtils.getInfo().getLowAddress() + " ~ " + subnetUtils.getInfo().getHighAddress());
                    return true;
                }
            }
        }        

        response.sendRedirect("/error/filter400.do");
        return false;
    }
    
    private String getClinetIp(HttpServletRequest request) {
        String clientIp = request.getHeader("X-FORWARDED-FOR");
        //=================================================================
        if (logger.isDebugEnabled()) logger.debug("[X-Forwarded-For]: {}", request.getHeader("X-Forwarded-For"));
        if (logger.isDebugEnabled()) logger.debug("[Proxy-Client-IP]: {}", request.getHeader("Proxy-Client-IP"));
        if (logger.isDebugEnabled()) logger.debug("[WL-Proxy-Client-IP]: {}", request.getHeader("WL-Proxy-Client-IP"));
        if (logger.isDebugEnabled()) logger.debug("[HTTP_CLIENT_IP]: {}", request.getHeader("HTTP_CLIENT_IP"));
        if (logger.isDebugEnabled()) logger.debug("[HTTP_X_FORWARDED_FOR]: {}", request.getHeader("HTTP_X_FORWARDED_FOR"));
        if (logger.isDebugEnabled()) logger.debug("[getRemoteAddr()]: {}", request.getRemoteAddr());
        //=================================================================clientIp
        clientIp = request.getHeader("X-Forwarded-For");
        if (clientIp == null || clientIp.length() == 0) clientIp = request.getHeader("Proxy-Client-IP");
        if (clientIp == null || clientIp.length() == 0) clientIp = request.getHeader("WL-Proxy-Client-IP"); // 웹로직
        if (clientIp == null || clientIp.length() == 0) clientIp = request.getHeader("HTTP_CLIENT_IP");
        if (clientIp == null || clientIp.length() == 0) clientIp = request.getHeader("HTTP_X_FORWARDED_FOR");
        if (clientIp == null || clientIp.length() == 0) clientIp = request.getRemoteAddr();
        if (clientIp == null || "0:0:0:0:0:0:0:1".equals(clientIp)) clientIp = "127.0.0.1";

        if (logger.isDebugEnabled()) logger.info("[{}] client IP ", request.getMethod(), clientIp); //접속한 사용자의 IPv4

        return clientIp;
    }
    
//    private Long ipToLong(String ip) { //ip를 Long 형식으로 
//        String[] ipArr = ip.split("\\."); //현재 접속 아이피 분리
//        
//        //현재 접속 아이피를 long으로 변환
//        long ipLong = (Long.parseLong(ipArr[0]) << 24) +
//            (Long.parseLong(ipArr[1]) << 16) +
//            (Long.parseLong(ipArr[2]) << 8) +
//            (Long.parseLong(ipArr[3]));
//
//        return ipLong;
//    }
    
//    private boolean ipCheck(String clientIp, String startIp, String endIp) {
//        Long clientIpL = ipToLong(clientIp);
//        Long startIpL = ipToLong(startIp);
//        Long endIpL = ipToLong(endIp);
//        if (clientIpL >= startIpL &&  clientIpL <= endIpL) {
//            return true;
//        }
//        return false;
//    }

}
