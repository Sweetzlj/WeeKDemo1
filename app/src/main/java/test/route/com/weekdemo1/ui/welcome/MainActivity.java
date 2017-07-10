package test.route.com.weekdemo1.ui.welcome;


import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.jude.rollviewpager.OnItemClickListener;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import test.route.com.weekdemo1.R;
import test.route.com.weekdemo1.adapter.TestNormalAdapter;
import test.route.com.weekdemo1.ui.homepage.HomeActivity;
import test.route.com.weekdemo1.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RollPagerView mRollViewPager;
    private Button button;
    private boolean isfirst;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRollViewPager = (RollPagerView) findViewById(R.id.roll_view_pager);
        button = (Button) findViewById(R.id.button);
        //获取SharedPreferences对象
        SharedPreferences share = getSharedPreferences("zlj", MODE_PRIVATE);
        isfirst = share.getBoolean("isfirst", false);
        initpager();
        button.setOnClickListener(this);
    }

    private void initpager() {
        //设置播放时间间隔
        mRollViewPager.setPlayDelay(1000);
        //设置透明度
        mRollViewPager.setAnimationDurtion(500);
        //设置适配器
        mRollViewPager.setAdapter(new TestNormalAdapter());
        button.setVisibility(View.INVISIBLE);
        //设置指示器（顺序依次）
        //自定义指示器图片
        //设置圆点指示器颜色
        //设置文字指示器
        //隐藏指示器
      //  mRollViewPager.setHintView(new IconHintView(this, R.drawable.point_focus, R.drawable.point_normal));
        mRollViewPager.setHintView(new ColorPointHintView(this, Color.YELLOW,Color.WHITE));
        mRollViewPager.setOnItemClickListener(new OnItemClickListener() {

            public void onItemClick(int position) {

                if(position==2){
                    mRollViewPager.pause();
                    button.setVisibility(View.VISIBLE);
                    Log.e("VISIBLE","VISIBLE");
                }else{
                    mRollViewPager.resume();
                    mRollViewPager.isPlaying();
                    button.setVisibility(View.INVISIBLE);
                    Log.e("INVISIBLE","INVISIBLE");
                }
            }
        });
    }
    @Override
    public void onClick(View v) {
        if(isfirst){

//			以前登陆过就跳转到主界面
            Intent intent=new Intent(MainActivity.this, HomeActivity.class);
            MainActivity.this.startActivity(intent);
            finish();

        }else{
//			是第一次登录就跳转到登录界面
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            MainActivity.this.startActivity(intent);
            finish();
        }
    }
}