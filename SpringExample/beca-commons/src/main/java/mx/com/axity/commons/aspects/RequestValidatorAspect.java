package mx.com.axity.commons.aspects;

import mx.com.axity.commons.to.ErrorTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.NoSuchElementException;

@Aspect
@Configuration
public class RequestValidatorAspect {

    static final Logger LOG = LogManager.getLogger(RequestValidatorAspect.class);

    @Around(value = "execution(* mx.com.axity.web.rest.*.*(..))  && args(..)")
    public ResponseEntity execute(ProceedingJoinPoint joinPoint) {
        ResponseEntity result;
        try {
            LOG.info("Access");
            LOG.info(String.format("Execution: %s", joinPoint.getSignature()));
            result = (ResponseEntity) joinPoint.proceed();
            return result;
        }catch (Throwable e) {
            LOG.info("Exception Ocurred");
            LOG.info("Execution: {}", joinPoint.getSignature());
            LOG.info("Exception: {}", e.getMessage());
            ErrorTO errorTo = new ErrorTO();
            if (e instanceof NoSuchElementException){
                errorTo.setErrorCode(1);
                errorTo.setErrorMessage("No existe el usuario, no se puede actualizar");
            } else{
                errorTo.setErrorCode(0);
                errorTo.setErrorMessage("Intente mas tarde");
            }
            result = new ResponseEntity<>(errorTo, HttpStatus.NOT_FOUND);
            return result;
            //throw new BusinessException("Error", e);
        }
    }
}
