package test.route.com.weekdemo1.ui.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import test.route.com.weekdemo1.R;
import test.route.com.weekdemo1.ui.homepage.HomeActivity;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_psw)
    EditText etPsw;
    @BindView(R.id.bt_login)
    Button btLogin;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.img_qq)
    ImageView imgQq;
    @BindView(R.id.img_wechat)
    ImageView imgWechat;
    @BindView(R.id.img_sina)
    ImageView imgSina;
    private SharedPreferences sp2;
    private SharedPreferences.Editor edit;
    private String name2;
    private String psw2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        sp2 = getSharedPreferences("zlj", MODE_PRIVATE);
        edit = sp2.edit();
        name2 = sp2.getString("name", "");
        psw2 = sp2.getString("psw", "");
        etName.setText(name2);
        etPsw.setText(psw2);

    }

    @OnClick(R.id.bt_login)
    public void onViewClicked() {
        String name = etName.getText().toString().trim();
        String psw = etPsw.getText().toString().trim();

        /*判断用户名、密码是否为空，
        不为空的话 ，就跳转到主界面*/
        if (!"".equals(name) && !"".equals(psw)) {
            if (name.equals(name2) && psw.equals(psw2)) {
                Toast toast = Toast.makeText(LoginActivity.this, "登陆成功！", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                //是否是第一次登陆
                edit.putBoolean("isfirst", true);
                edit.apply();
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                LoginActivity.this.startActivity(intent);
                finish();
            } else {
                Toast toast = Toast.makeText(LoginActivity.this, "账号或密码错误！", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }

            //为空的话就吐司提示
        } else {
            Toast toast = Toast.makeText(LoginActivity.this, "账号或密码不能为空！", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
    }

    @OnClick({R.id.tv1, R.id.tv2,R.id.img_qq, R.id.img_wechat, R.id.img_sina})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv1:
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(intent);
                break;
            case R.id.tv2:
                Intent intent1 = new Intent(LoginActivity.this, ForGetActivity.class);
                LoginActivity.this.startActivity(intent1);
                break;
            case R.id.img_qq:
                Login(SHARE_MEDIA.QQ);
                break;
            case R.id.img_wechat:
                Login(SHARE_MEDIA.WEIXIN);
                break;
            case R.id.img_sina:
                Login(SHARE_MEDIA.SINA);
                break;
        }
    }

    private void Login(SHARE_MEDIA share_media) {
        UMShareAPI mShareAPI = UMShareAPI.get(LoginActivity.this);
        mShareAPI.getPlatformInfo(LoginActivity.this, share_media, new UMAuthListener() {
            @Override
            public void onStart(SHARE_MEDIA platform) {
            }

            @Override
            public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
                String temp = "";
                for (String key : data.keySet()) {
                    temp = temp + key + " : " + data.get(key) + "\n";
                }

                Toast.makeText(LoginActivity.this, platform + " 成功啦", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(SHARE_MEDIA platform, int action, Throwable t) {

                Toast.makeText(LoginActivity.this, platform + " 失败啦", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel(SHARE_MEDIA platform, int action) {
                Toast.makeText(LoginActivity.this, platform + " 取消了", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}
