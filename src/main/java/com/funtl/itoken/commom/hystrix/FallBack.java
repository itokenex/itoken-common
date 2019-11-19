package com.funtl.itoken.commom.hystrix;

import com.funtl.itoken.commom.BaseResult;
import com.funtl.itoken.commom.constants.HttpStatusConstants;
import com.funtl.itoken.commom.utils.MapperUtils;
import com.google.common.collect.Lists;

public class FallBack {
    /**
     * 通用的熔断方法
     * @return String
     */
    public static String  badGateway(){
        BaseResult baseResult = BaseResult.notOk(
                Lists.newArrayList(
                        new BaseResult.Error(String.valueOf(HttpStatusConstants.BAD_GATEWAY.getStatus()),
                                HttpStatusConstants.BAD_GATEWAY.getContent())));
        try {
            return MapperUtils.obj2json(baseResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
