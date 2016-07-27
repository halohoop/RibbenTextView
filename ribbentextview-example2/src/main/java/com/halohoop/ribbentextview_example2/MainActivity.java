package com.halohoop.ribbentextview_example2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.halohoop.ribbentextview.RibbenTextView;

import java.util.Random;

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

    private String[] ribbenTexts = {"新手专享", "new", "积分+", "充值+",
            "红包+", "亲密付+", "天猫+", "淘宝+",
            "外卖+", "理财小工具+", "手机充值+", "蚂蚁聚宝+",
            "记账本+", "蚂蚁花呗+", "阿里旅行+", "服务窗+",
            "天猫超市+", "超时惠+", "亲情账户+", "我的客服+",
            "汇率换算+", "我的快递+", "城市服务+", "保险服务+",
            "易积分+", "虾米音乐+", "滴滴出行+", "阿里体育+",
            "发票管家+", "加油服务+", "淘票票+", "校园生活+", "彩票+"};
    private String[] ribbenColors = {"#7B68EE", "#7AC5CD", "#7A8B8B", "#7A7A7A",
            "#7A67EE", "#7A378B", "#79CDCD", "#787878",
            "#778899", "#76EEC6", "#76EE00", "#757575",
            "#737373", "#71C671", "#7171C6", "#708090",
            "#707070", "#6E8B3D", "#6E7B8B", "#6E6E6E",
            "#6CA6CD", "#6C7B8B", "#6B8E23", "#6B6B6B",
            "#6A5ACD", "#698B69", "#698B22", "#696969",
            "#6959CD", "#68838B", "#68228B", "#66CDAA",
            "#66CD00", "#668B8B", "#666666", "#6495ED",
            "#63B8FF", "#636363", "#616161", "#607B8B",
            "#5F9EA0", "#5E5E5E", "#5D478B", "#5CACEE",
            "#5C5C5C", "#5B5B5B", "#595959", "#575757"};

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
            RibbenTextView rtv = (RibbenTextView) inflate.findViewById(R.id.rtv);
            TextView tv = (TextView) inflate.findViewById(R.id.tv);
            tv.setText(texts[i]);
            rtv.setText(ribbenTexts[i]);
            Random rand = new Random();
            int randNum = rand.nextInt(ribbenColors.length);
            int ribbenColor = android.graphics.Color.parseColor(ribbenColors[randNum]);
            int textColor = android.graphics.Color.parseColor("#ffffffff");
            rtv.setTextColor(textColor);
            rtv.setRibbenColor(ribbenColor);
            return inflate;
        }
    }
}
