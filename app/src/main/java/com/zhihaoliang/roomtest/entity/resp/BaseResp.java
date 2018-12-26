package com.zhihaoliang.roomtest.entity.resp;


/**
 * 创建日期：2018/12/24
 * 描述: 请求的公共接口Bean
 * 作者:支豪亮
 */
public class BaseResp<T> {
    /**
     * success : true
     * ctx :
     * share_current_request_time : 1545631758856
     */

    private boolean success;

    private T result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }


}
