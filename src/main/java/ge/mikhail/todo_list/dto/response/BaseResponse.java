package ge.mikhail.todo_list.dto.response;

import ge.mikhail.todo_list.enums.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class BaseResponse {
    private int code = ErrorCode.OK.getCode();
    private String detail = "";
}
