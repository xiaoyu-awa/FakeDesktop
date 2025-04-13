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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //透明上下两栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        //获取日期文本
        TextView date = findViewById(R.id.date);
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("MM月dd日");
        date.setText(ft.format(dNow));
        //获取日期文本
        TextView week = findViewById(R.id.week);
        week.setText(String.format("%tA%n", dNow));
    }
}