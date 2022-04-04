package common.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

//@Repository
public class ControllerLogAspect {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	public void beforeLog(JoinPoint joinPoint) throws Throwable {

	    try {
            if (logger.isDebugEnabled()) {
                Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
                String[] paths = method.getAnnotation(RequestMapping.class).produces();//.path();
                String[] values = method.getAnnotation(RequestMapping.class).value();
                
                String path = paths != null && paths.length > 0 ? paths[0] : (values != null && values.length > 0 ? values[0] : "");
                
        	    String log = "\n"
        	    	+ "* =============================================================================================\n"
					+ "* RequestMapping: "+path+"\n"
					+ "* Class.Method  : "+method.getName()+"\n"
					+ "* Arguments     : "+joinPoint.getArgs()+"\n"
					+ "* ============================================================================================= Started "+joinPoint.getTarget().getClass().getName()+"."+method.getName();
                
                logger.debug(log);
            }
	    } catch (Throwable t) {
            t.printStackTrace();
            throw t;
        }
	}
	

    public void afterLog(JoinPoint joinPoint) throws Throwable {

        try {
            if (logger.isDebugEnabled()) {
                Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
                logger.debug("\n* ============================================================================================= Stopped {}.{}",
                    joinPoint.getTarget().getClass().getName(),
                    method.getName()
                );
            }
        } catch (Throwable t) {
            t.printStackTrace();
            throw t;
        }
    }
    
}