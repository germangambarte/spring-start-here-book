package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

import java.util.logging.Logger;


@Aspect
@Order(2)
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("@annotation(ToLog)")
    public Object log(ProceedingJoinPoint jp) throws Throwable {
        logger.info("Calling the intercepted method");
        Object returnedValue = jp.proceed();
        logger.info("Method executed returned: " + returnedValue);
        return returnedValue;
    }
}
