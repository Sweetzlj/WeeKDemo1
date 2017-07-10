package test.route.com.weekdemo1.ui.homepage;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import test.route.com.weekdemo1.R;
import test.route.com.weekdemo1.adapter.TestNormalAdapter;
import test.route.com.weekdemo1.ui.info.VideoActivity;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.rollpager)
    RollPagerView rollpager;
    @BindView(R.id.video)
    Button video;
    @BindView(R.id.picture)
    Button picture;
    @BindView(R.id.clazz)
    Button clazz;
    @BindView(R.id.local)
    Button local;
    @BindView(R.id.knowledge)
    Button knowledge;
    @BindView(R.id.sea)
    Button sea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        initPager();
    }

    private void initPager() {
        //设置播放时间间隔
        rollpager.setPlayDelay(1000);
        //设置透明度
        rollpager.setAnimationDurtion(500);
        //设置适配器
        rollpager.setAdapter(new TestNormalAdapter());

        //设置指示器（顺序依次）
        //自定义指示器图片
        //设置圆点指示器颜色
        //设置文字指示器
        //隐藏指示器
        //mRollViewPager.setHintView(new IconHintView(this, R.drawable.point_focus, R.drawable.point_normal));
        rollpager.setHintView(new ColorPointHintView(this, Color.YELLOW,Color.WHITE));
    }

    @OnClick({R.id.video, R.id.picture, R.id.clazz, R.id.local, R.id.knowledge, R.id.sea})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.video:
                Intent intent = new Intent(HomeActivity.this, VideoActivity.class);
                HomeActivity.this.startActivity(intent);
                break;
            case R.id.picture:
                break;
            case R.id.clazz:
                break;
            case R.id.local:
                break;
            case R.id.knowledge:
                break;
            case R.id.sea:
                break;
        }
    }
}
