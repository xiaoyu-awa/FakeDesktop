package cn.xiaoyu_awa.fakedesktop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HomeActivity extends Activity implements View.OnClickListener {
    TextView date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //透明上下两栏
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        //获取日期文本
        date = findViewById(R.id.txtDate);
        Date dNow = new Date();
        date.setText(new SimpleDateFormat("MM月dd日").format(dNow));
        //获取日期文本
        TextView week = findViewById(R.id.txtWeek);
        week.setText(String.format("%tA%n", dNow));

        ImageButton btn_zuoYeBang = findViewById(R.id.btnZuoYeBang);
        btn_zuoYeBang.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnZuoYeBang) {
            Toast.makeText(this, "作业帮 启动！", Toast.LENGTH_SHORT).show();
            Intent intent = getPackageManager().getLaunchIntentForPackage("com.baidu.homework");

            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
                intent.addCategory(Intent.CATEGORY_LAUNCHER);
            }

            if (intent != null) {
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }else {
                Toast.makeText(this, "null", Toast.LENGTH_SHORT).show();
            }
        }
    }
}