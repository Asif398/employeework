package com.asif.exception;

import com.asif.payload.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

//@ControllerAdvice
//public class HandleException {
//
//    @ExceptionHandler(ResourceNotFound.class)
//    public ResponseEntity<String> handleEmployeeNotFoundException(
//            ResourceNotFound e
//    ){
//
//      return  new ResponseEntity<>("Record was not found", HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//}


@ControllerAdvice
public class HandleException {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ErrorDetails> handleEmployeeNotFoundException(
            ResourceNotFound e,
            WebRequest request
    ){
        ErrorDetails errorDetails  = new ErrorDetails(

                e.getMessage(),
                new Date(),
//                request.getDescription(true)
                request.getDescription(false)
        );
        return  new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> globalException(
            Exception e,
            WebRequest request
    ){
        ErrorDetails errorDetails  = new ErrorDetails(

                e.getMessage(),
                new Date(),
//                request.getDescription(true)
                request.getDescription(false)
        );
        return  new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String > globalException(
//            Exception e,
//            WebRequest request
//    ){
//        ErrorDetails errorDetails  = new ErrorDetails(
//
//                e.getMessage(),
//                new Date(),
////                request.getDescription(true)
//                request.getDescription(false)
//        );
//        return  new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR);
//    }



}

