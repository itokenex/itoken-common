package com.funtl.itoken.commom;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class BaseResult implements Serializable{
    private String result;
    private Object data;
    private  String success;
    private List<BaseResult.Error> errors;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public List<BaseResult.Error> getErrors() {
        return errors;
    }

    public void setErrors(List<BaseResult.Error> errors) {
        this.errors = errors;
    }

    public static BaseResult ok(Object data){
        return createResult("ok",data,"成功操作",null,null);
    }
    public static BaseResult notOk(List<BaseResult.Error> errors){
        return createResult("notOk",null,"",null,errors);
    }


    private static BaseResult createResult(String result, Object data, String success, Cursor cursor, List<BaseResult.Error> errors){
        BaseResult baseResult = new BaseResult();
        baseResult.setResult(result);
        baseResult.setData(data);
        baseResult.setSuccess(success);
        baseResult.setErrors(errors);

        return baseResult;
    }


    @Data
    public static class Cursor{
        private int total;
        private int offset;
        private int limit;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }
    }

    @Data
    public static class Error {
        private String field;
        private String message;

        public Error(String field, String message) {
            this.field = field;
            this.message =message;
        }

        public Error() {

        }


        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
