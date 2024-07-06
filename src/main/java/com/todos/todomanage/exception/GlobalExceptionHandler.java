package com.todos.todomanage.exception;


import com.todos.todomanage.controllers.ToDoControllers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    Logger log= LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(NullPointerException.class)
    //@ExceptionHandler(value={NullPointerException.class, NumberFormatException.class, ArrayIndexOutOfBoundsException.class})
    public ResponseEntity<String> nullPointerExceptionHandler(NullPointerException ex){
        return new ResponseEntity<String>("Some Issue found in application .... "+ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(NumberFormatException.class)
    //@ExceptionHandler(value={NullPointerException.class, NumberFormatException.class, ArrayIndexOutOfBoundsException.class})
    public ResponseEntity<String> nunmberFormatExceptionHandler(NumberFormatException ex){
        return new ResponseEntity<String>("Some Issue found in application .... "+ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

    }

    // Handling Resource Not Found Exception
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> resourceNotFoundException(ResourceNotFoundException res){
        log.info("Error :{}"+res.getMsg());
        ExceptionResponse response=new ExceptionResponse();
        response.setMsg(res.getMsg());
        response.setStatus(HttpStatus.NOT_FOUND);
        response.setSuccess(false);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

}


