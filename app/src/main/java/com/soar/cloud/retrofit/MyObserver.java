package com.soar.cloud.retrofit;


import io.reactivex.Observer;

/**
 * 继承Subscriber_重写onError方法
 */
public abstract class MyObserver<T> implements Observer<T> {

    @Override
    public void onError(Throwable e) {
        if(e instanceof APIException)
            onError((APIException)e);
        else
            onError(new APIException(e,ExceptionEngine.ERROR.DEFAULT_ERROR));//其他默认code 0001
    }

    /**
     * 自定义错误回调
     */
    protected abstract void onError(APIException ex);
}