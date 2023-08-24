package ge.mikhail.todo_list.exception;

import ge.mikhail.todo_list.enums.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GeneralException extends Exception {

    private final ErrorCode errorCode;
    private final String detail;
}
