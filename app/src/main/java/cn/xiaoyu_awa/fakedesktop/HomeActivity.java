package cn.xiaoyu_awa.fakedesktop;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HomeActivity extends Activity {
    TextView date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //透明上下两栏
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        //获取日期文本
        date = findViewById(R.id.date);
        Date dNow = new Date();
        date.setText(new SimpleDateFormat ("MM月dd日").format(dNow));
        //获取日期文本
        TextView week = findViewById(R.id.week);
        week.setText(String.format("%tA%n", dNow));
    }
}