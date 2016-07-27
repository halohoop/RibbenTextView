package com.halohoop.ribbentextview_example2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private GridView mGv;
    private String[] texts = {"芝麻信用", "信用卡还款", "转账", "余额宝",
            "红包", "亲密付", "天猫", "淘宝",
            "外卖", "理财小工具", "手机充值", "蚂蚁聚宝",
            "记账本", "蚂蚁花呗", "阿里旅行", "服务窗",
            "天猫超市", "超时惠", "亲情账户", "我的客服",
            "汇率换算", "我的快递", "城市服务", "保险服务",
            "易积分", "虾米音乐", "滴滴出行", "阿里体育",
            "发票管家", "加油服务", "淘票票", "校园生活", "彩票"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGv = (GridView) findViewById(R.id.gv);
        mGv.setAdapter(new MyBaseAdapter());

    }

    class MyBaseAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return texts.length;
        }

        @Override
        public Object getItem(int i) {
            return texts[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View inflate = View.inflate(MainActivity.this, R.layout.item, null);
            TextView tv = (TextView) inflate.findViewById(R.id.tv);
            tv.setText(texts[i]);
            return inflate;
        }
    }
}
