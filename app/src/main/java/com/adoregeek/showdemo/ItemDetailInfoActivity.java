package com.adoregeek.showdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.adoregeek.showdemo.dummy.DummyContent;
import com.adoregeek.showdemo.util.ImageLoadUtil;

public class ItemDetailInfoActivity extends AppCompatActivity {
    ImageView ivGoodImg;
    TextView tvName;
    TextView tvNum;
    TextView tvSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail_info);
        initData();
        initView();
    }

    private void initView() {
        ivGoodImg = (ImageView) findViewById(R.id.iv_good_img);
        tvName = (TextView) findViewById(R.id.tv_name);
        tvNum = (TextView) findViewById(R.id.tv_num);
        tvSize = (TextView) findViewById(R.id.tv_size);
        ImageLoadUtil.load(this, data.getGood_img(), ivGoodImg);
        tvName.setText(data.getGood_name() + "");
        tvNum.setText(data.getGood_num() + "");
        tvSize.setText(data.getGood_size() + "");
    }

    private DummyContent.GoodItem data;

    private void initData() {
        Intent intent = getIntent();
        data = intent.getParcelableExtra("data");
    }
}
