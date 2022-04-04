package common.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DaoLogAspect {

	private static final Logger logger = LoggerFactory.getLogger(DaoLogAspect.class);

    public void beforeLog(JoinPoint joinPoint) throws Throwable {
        try {
            if (logger.isDebugEnabled()) {
                logger.debug(
                    new StringBuilder("\n")
                        .append("* ---------------------------------------------------------------------------------------------\n")
                        .append("* Class.Method  : {}.{}\n")
                        .append("* Arguments     : {}\n")
                        .append("* --------------------------------------------------------------------------------------------- Started {}.{}")
                        .toString()
//                        ,
//                    joinPoint.getTarget().getClass().getName(),
//                    joinPoint.getSignature().getName(),
//                    joinPoint.getArgs(),
//                    joinPoint.getTarget().getClass().getName(),
//                    joinPoint.getSignature().getName()
                );
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
                logger.debug("* --------------------------------------------------------------------------------------------- Stopped {}.{}\n",
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