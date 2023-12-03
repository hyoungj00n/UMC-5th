package study.base.exception.handler;

import study.base.ErrorStatus;
import study.base.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {

    public FoodCategoryHandler(ErrorStatus errorCode){
        super(errorCode);
    }
}
