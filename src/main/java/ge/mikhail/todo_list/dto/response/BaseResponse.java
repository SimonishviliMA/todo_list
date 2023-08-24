package ge.mikhail.todo_list.dto.response;

import ge.mikhail.todo_list.enums.ErrorCode;
import lombok.Data;

@Data
public class BaseResponse {
    private int code = ErrorCode.OK.getCode();
    private String detail = "";
}
