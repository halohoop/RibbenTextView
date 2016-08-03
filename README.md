# RibbenTextView

![Markdown](http://i2.piimg.com/8359/35970be4a38edf4c.jpg)
![Markdown](http://i2.piimg.com/8359/47c127b80a368964.jpg)

#Usage 

**compile 'com.halohoop:ribbentextview:1.0.1'**

    <com.halohoop.ribbentextview.RibbenTextView
        android:id="@+id/rtv"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:background="#ffff0000"
        android:padding="10dp"
        app:ribben_color="#ff000000"
        app:text="newer treats!"
        app:text_color="#ffffffff"
        app:text_padding_left_and_right="40"
        app:text_padding_top_and_bottom="40"
        app:text_size="30" />

    <com.halohoop.ribbentextview.RibbenTextView
        android:id="@+id/rtv"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="right|bottom"
        app:rotate_position="right_bottom"
        app:text="新手专享"
        app:text_padding_left_and_right="0"
        app:text_padding_top_and_bottom="2"
        app:text_size="9"></com.halohoop.ribbentextview.RibbenTextView>

* and you can update text color, text size and ribben color in code;
<pre><code>
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
	//---------------------------------
    RibbenTextView rtv = (RibbenTextView) inflate.findViewById(R.id.rtv);
    Random rand = new Random();
    int randNum = rand.nextInt(ribbenTexts.length);
    rtv.setText(ribbenTexts[i]);
    randNum = rand.nextInt(ribbenColors.length);
    int ribbenColor = android.graphics.Color.parseColor(ribbenColors[randNum]);
    int textColor = android.graphics.Color.parseColor("#ffffffff");
    rtv.setTextColor(textColor);
    rtv.setRibbenColor(ribbenColor);
</code></pre>
# Customization
![Markdown](http://i2.piimg.com/8359/fa599ea48f22288e.png)

* ① edit by custom the attr named "**text\_padding\_top\_and\_bottom**";
* ② edit by custom the attr named "**text\_padding\_left\_and\_right**";
* edit text by custom the attr named "**text**";
* edit text size by custom the attr named "**text\_size**";
* edit text color by custom the attr named "**text\_color**";

# Compatibility
  
  * Android GINGERBREAD 2.3+
  
# Changelog

### Version: 1.0

  * Initial Build

## License

    Copyright 2016, Halohoop

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
