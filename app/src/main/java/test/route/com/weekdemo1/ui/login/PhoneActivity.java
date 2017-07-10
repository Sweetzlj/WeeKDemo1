package test.route.com.weekdemo1.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import test.route.com.weekdemo1.R;

public class PhoneActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.et_phone)
    EditText etPhone;

    private int a = 60;
    private Boolean isFirst = false;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    a--;
                    btSend.setText(a + "");

                    break;
            }
        }
    };
    private Button btSend;
    private Button bt_finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        ButterKnife.bind(this);
        btSend = (Button) findViewById(R.id.bt_send);
        bt_finish = (Button) findViewById(R.id.bt_finish);
        btSend.setOnClickListener(this);
        bt_finish.setOnClickListener(this);

        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
                while (a >= 0) {
                    try {
                        sleep(1000);
                            handler.sendEmptyMessage(1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_send:
                isFirst=true;
                break;
            case R.id.bt_finish:
                Intent intent=new Intent(PhoneActivity.this,LoginActivity.class);
                PhoneActivity.this.startActivity(intent);
                finish();
                break;
        }
    }
}
