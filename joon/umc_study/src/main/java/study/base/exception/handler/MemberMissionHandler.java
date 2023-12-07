package study.base.exception.handler;

import study.base.ErrorStatus;
import study.base.exception.GeneralException;

public class MemberMissionHandler extends GeneralException {

    public MemberMissionHandler(ErrorStatus errorCode){
        super(errorCode);
    }
}