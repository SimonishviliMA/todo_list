package ge.mikhail.todo_list.exception;

import ge.mikhail.todo_list.enums.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GeneralException extends RuntimeException {

    private final ErrorCode errorCode;
    private final String detail;
}
