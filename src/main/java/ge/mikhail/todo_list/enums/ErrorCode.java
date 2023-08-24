package ge.mikhail.todo_list.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    OK(0),
    NOT_FOUND(-1),
    UNKNOWN_EXCEPTION(-100);

    private final int code;
}
