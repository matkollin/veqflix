package at.matkollin.veqflix.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * ResourceNotFoundException is the superclass of those exceptions that can be thrown whenever a resource
 * is expected to exist, but doesn't.
 * The resource itself should be on a normal case an identifier or unique value such as a username or email.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

  public ResourceNotFoundException(String message) {
    super(message);
  }

  public ResourceNotFoundException(String message, Throwable ex) {
    super(message, ex);
  }

}
