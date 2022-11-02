package at.matkollin.veqflix.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * ResourceAlreadyExistsException is the superclass of those exceptions that can be thrown whenever a resource
 * is expected not to exist, but does.
 * The resource itself should be on a normal case an identifier or unique value such as a username or email.
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class ResourceAlreadyExistsException extends RuntimeException {

  public ResourceAlreadyExistsException(String message) {
    super(message);
  }

  public ResourceAlreadyExistsException(String message, Throwable ex) {
    super(message, ex);
  }

}
