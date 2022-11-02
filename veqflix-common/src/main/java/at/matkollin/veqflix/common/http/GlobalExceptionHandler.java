package at.matkollin.veqflix.common.http;

import at.matkollin.veqflix.common.exception.ResourceAlreadyExistsException;
import at.matkollin.veqflix.common.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public @ResponseBody ErrorResponse handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {
    return new ErrorResponse(HttpStatus.NOT_FOUND, resourceNotFoundException.getMessage());
  }

  @ExceptionHandler(ResourceAlreadyExistsException.class)
  public @ResponseBody ErrorResponse handleResourceAlreadyExistsException(ResourceAlreadyExistsException resourceAlreadyExistsException) {
    return new ErrorResponse(HttpStatus.CONFLICT, resourceAlreadyExistsException.getMessage());
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(ConstraintViolationException.class)
  public @ResponseBody ErrorResponse handleConstraintViolationException(ConstraintViolationException constraintViolationException) {
    return new ErrorResponse(HttpStatus.BAD_REQUEST, constraintViolationException.getMessage());
  }

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(Exception.class)
  public @ResponseBody ErrorResponse handleException(Exception exception) {
    return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
  }

}
