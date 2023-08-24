package ge.mikhail.todo_list.exception;

import ge.mikhail.todo_list.dto.response.BaseResponse;
import ge.mikhail.todo_list.enums.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<BaseResponse> handleThrowableException(Throwable ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new BaseResponse(ErrorCode.UNKNOWN_EXCEPTION, ex.getMessage()));
    }

    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<BaseResponse> handleGeneralException(GeneralException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new BaseResponse(ex.getErrorCode(), ex.getDetail()));
    }

}
