package common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.UrlPathHelper;

/**
 * Context path 변수 지정 인터셉터
 */
public class InjectionInterceptor extends HandlerInterceptorAdapter {
    
//    private static final Logger logger = LoggerFactory.getLogger(InjectionInterceptor.class);

    @Value("${Globals.System.Name}")
    private String systemName;

    @Value("${Globals.System.Desc}")
    private String systemDesc;

    @Value("${Globals.System.Version}")
    private String systemVersion;
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
        try {
            
            UrlPathHelper urlPathHelper = new UrlPathHelper();
            String ctxPath = urlPathHelper.getOriginatingContextPath(request);//request.getContextPath();
            String curPath = urlPathHelper.getOriginatingRequestUri(request); //request.getRequestURI();
            String ctlPath = urlPathHelper.getOriginatingServletPath(request);//request.getServletPath(); // Controller Path

            //if (logger.isDebugEnabled()) logger.debug("CTX_PATH ==> {}", ctxPath);
            //if (logger.isDebugEnabled()) logger.debug("CTL_PATH ==> {}", ctlPath);
            //if (logger.isDebugEnabled()) logger.debug("CUR_PATH ==> {}", curPath);
            //if (logger.isDebugEnabled()) logger.debug("[{}] {} SessionId: {}", request.getMethod(), request.getRequestURL(), request.getRequestedSessionId());

            String ctxRoot = "";
            String proc = request.getScheme();
            String server = request.getServerName();
            int port = request.getServerPort();
            if ((443 == port && "https" == proc) || (80 == port && "http" == proc)) {
                ctxRoot = String.format("%s://%s", proc, server);
            } else {
                ctxRoot = String.format("%s://%s:%d", proc, server, port);
            }

            request.setAttribute("CTX_ROOT", ctxRoot);
            request.setAttribute("CTX_PATH", ctxPath);
            request.setAttribute("CTL_PATH", ctlPath);
            request.setAttribute("CUR_PATH", curPath);
            request.setAttribute("SYS_NAME", systemName);
            request.setAttribute("SYS_DESC", systemDesc);
            request.setAttribute("SYS_VERSION", systemVersion);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return super.preHandle(request, response, handler);
    }
}