package com.student.application.student_application.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleValidationExceptions( ConstraintViolationException exception) {

        List<String> errors
                = exception.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
        Map<String,List<String>> errorMap = new HashMap<>();
        errorMap.put("errors" , errors);
        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);


    }


    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException( IllegalArgumentException exception) {

        return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);

    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<Object> handleUserAlreadyExistException(UserAlreadyExistsException exp){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("erros:", exp.getMessage());
        return  new ResponseEntity<>(errorMap, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NoUserFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserAlreadyExistException(NoUserFoundException exp, HttpServletRequest request){

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage( exp.getMessage());
        errorResponse.setDateTime(ZonedDateTime.now(ZoneId.of("Z")));
        errorResponse.setResponseStatus(HttpStatus.NOT_FOUND);
        errorResponse.setPath(request.getRequestURI());

        return  new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<Object> handleIntegrityConstraintViolation(SQLIntegrityConstraintViolationException ex) {
        // Handle integrity constraint violation exception
        return new ResponseEntity<>(" Integrity constraint (foreign key, primary key or unique key) has been violated: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SQLSyntaxErrorException.class)
    public ResponseEntity<Object> handleSyntaxError(SQLSyntaxErrorException ex) {
        // Handle syntax error exception
        return new ResponseEntity<>("SQL Syntax error: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(SQLDataException.class)
    public ResponseEntity<Object> handleDataException(SQLDataException ex) {
        // Handle data exception
        return new ResponseEntity<>("Invalid SQL Data exception: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(SQLTimeoutException.class)
    public ResponseEntity<Object> handleTimeoutException(SQLTimeoutException ex) {
        // Handle SQL timeout exception
        return new ResponseEntity<>("SQL Timeout Exception: " + ex.getMessage(), HttpStatus.REQUEST_TIMEOUT);
    }

    @ExceptionHandler(SQLNonTransientConnectionException.class)
    public ResponseEntity<Object> handleNonTransientConnectionException(SQLNonTransientConnectionException ex) {
        // Handle non-transient connection exception
        return new ResponseEntity<>("Connection to the database cannot be established or is lost: " + ex.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(SQLFeatureNotSupportedException.class)
    public ResponseEntity<Object> handleFeatureNotSupportedException(SQLFeatureNotSupportedException ex) {
        // Handle feature not supported exception
        return new ResponseEntity<>("SQL Feature Not Supported: " + ex.getMessage(), HttpStatus.NOT_IMPLEMENTED);
    }


    @ExceptionHandler(SQLClientInfoException.class)
    public ResponseEntity<Object> handleClientInfoException(SQLClientInfoException ex) {
        // Handle client info exception
        return new ResponseEntity<>("SQL Client Info Exception: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SQLInvalidAuthorizationSpecException.class)
    public ResponseEntity<Object> handleInvalidAuthorizationSpecException(SQLInvalidAuthorizationSpecException ex) {
        // Handle invalid authorization specification exception
        return new ResponseEntity<>("Invalid authorization specification: " + ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<Object> handleSQLException(SQLException ex) {
        // Log the exception or handle it as needed
        return new ResponseEntity<>("SQL Exception occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


  /*  @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErrorResponseModel handleException(MethodArgumentNotValidException e) {
        List<ErrorModel> errorModels = processErrors(e);
        return ErrorResponseModel
                .builder()
                .errors(errorModels)
                .type(ErrorType.VALIDATION.toString())
                .build();
    }

    private List<ErrorModel> processErrors(MethodArgumentNotValidException e) {
        List<ErrorModel> validationErrorModels = new ArrayList<ErrorModel>();
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            ErrorModel validationErrorModel = ErrorModel
                    .builder()
                    .code(fieldError.getCode())
                    .source(fieldError.getObjectName() + "/" + fieldError.getField())
                    .detail(fieldError.getField() + " " + fieldError.getDefaultMessage())
                    .build();
            validationErrorModels.add(validationErrorModel);
        }
        return validationErrorModels;
    }
*/

/*    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ApiExceptionResponse handleResourceNotFoundException(ResourceNotFoundException ex, HttpServletRequest request) {
        ApiExceptionResponse response = new ApiExceptionResponse();
        response.setTimestamp(LocalDateTime.now());
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setError(HttpStatus.NOT_FOUND.getReasonPhrase());
        response.setMessage(ex.getMessage());
        response.setPath(request.getRequestURI());
        return response;
    }

    @ExceptionHandler(InvalidRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ApiExceptionResponse handleInvalidRequestException(InvalidRequestException ex, HttpServletRequest request) {
        ApiExceptionResponse response = new ApiExceptionResponse();
        response.setTimestamp(LocalDateTime.now());
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
        response.setMessage(ex.getMessage());
        response.setPath(request.getRequestURI());
        return response;
    }



    @ExceptionHandler(value = ClassNotFoundException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage classNotFoundException(ClassNotFoundException ex) {
        return new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new Date(),
                ex.getMessage(),
                "Class Not Found On The Classpath");
    }

    @ExceptionHandler(value = InvocationTargetException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage invocationTargetException(InvocationTargetException ex) {
        return new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new Date(),
                ex.getMessage(),
                "Failed To Invoke Method or Constructor");
    }*/


}
