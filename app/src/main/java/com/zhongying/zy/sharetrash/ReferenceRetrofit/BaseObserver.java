package com.zhongying.zy.sharetrash.ReferenceRetrofit;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.widget.Toast;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseObserver<T> implements Observer<BaseEntity<T>> {
    private Context mContext;
    private ProgressDialog mDialog;
    private Disposable mDisposable;
    private final int SUCCESS_CODE = 200;

    public BaseObserver(Context context, ProgressDialog dialog) {
        mContext = context;
        mDialog = dialog;

        mDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                mDisposable.dispose();
            }
        });
    }

    @Override
    public void onSubscribe(Disposable d) {
        mDisposable = d;
    }

    @Override
    public void onNext(BaseEntity<T> value) {
        if (value.getCode() == SUCCESS_CODE) {
            T t = value.getData();
            onHandleSuccess(t);
        } else {
            onHandleError(value.getCode(), value.getMessage());
        }
    }

    @Override
    public void onError(Throwable e) {
        Log.d("gesanri", "error:" + e.toString());

        if(mDialog != null && mDialog.isShowing()){
            mDialog.dismiss();
        }

        Toast.makeText(mContext, "网络异常，请稍后再试", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onComplete() {
        Log.d("gesanri", "onComplete");

        if(mDialog != null && mDialog.isShowing()){
            mDialog.dismiss();
        }
    }

    public abstract void onHandleSuccess(T t);

    void onHandleError(int code, String message) {
        Log.i("zyzyzy", "error:" + message);
        Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
    }
}
