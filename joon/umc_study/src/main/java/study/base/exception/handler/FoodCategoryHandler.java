package study.base.exception.handler;

import study.base.Code;
import study.base.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {

    public FoodCategoryHandler(Code errorCode){
        super(errorCode);
    }
}
