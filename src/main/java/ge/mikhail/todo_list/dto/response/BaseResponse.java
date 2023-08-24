package ge.mikhail.todo_list.dto.response;

import ge.mikhail.todo_list.enums.ErrorCode;
import lombok.Data;

@Data
public class BaseResponse {
    private final int code;
    private final String detail;

    public BaseResponse(ErrorCode errorCode, String detail) {
        this.code = errorCode.getCode();
        this.detail = detail;
    }

    public BaseResponse() {
        this.code = ErrorCode.OK.getCode();
        this.detail = "";
    }
}
