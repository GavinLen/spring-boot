package xyz.ieden.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Gavin
 * @date 2018.05.12
 */
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Service Error")
public class EdenServiceException extends RuntimeException {
}
