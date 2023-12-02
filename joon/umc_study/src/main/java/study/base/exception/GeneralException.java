package study.base.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import study.base.BaseErrorCode;
import study.base.ErrorReasonDTO;
import study.base.ErrorStatus;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason() {
        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus(){
        return this.code.getReasonHttpStatus();
    }
}
