package com.zhongying.zy.sharetrash.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.orhanobut.hawk.Hawk;
import com.zhongying.zy.sharetrash.R;
import com.zhongying.zy.sharetrash.UserService.UserInfo;
import com.zhongying.zy.sharetrash.constant.AppConfig;
import com.zhongying.zy.sharetrash.util.PictureUtil;

public class QrCodeActivity extends AppCompatActivity {
private ImageView qrCodePicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);
        qrCodePicture= (ImageView) findViewById(R.id.qrCodePicture);
        UserInfo userInfo= Hawk.get("user");
        String url= AppConfig.Picture+"upload/"+userInfo.getId()+"/qrcode.png";
        PictureUtil.showImage(qrCodePicture,this,url);
    }
}
