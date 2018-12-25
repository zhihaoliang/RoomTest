package com.zhihaoliang.roomtest.entity;


/**
 * 创建日期：2018/12/24
 * 描述: 请求的公共接口Bean
 * 作者:支豪亮
 */
public class BaseRep<T> {
    /**
     * result : [{"orderNum":"1","updateUser":"null","createUser":"null","createTime":"2017-12-27 21:28:50","updateTime":"2018-11-02 11:07:51","adUrl":"http://172.20.200.81:7011/upload/coopenAdvt-image/2018/11/2/19/15635-5d87-48e5-8bd3-45d0ff9bede.jpg","adStartTime":"2017-12-27 21:27:30","adEndTime":"2018-12-27 21:27:37","adLastTime":"3","turnUrl":"null","id":"74"}]
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
