package test.route.com.weekdemo1.ui.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import test.route.com.weekdemo1.R;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.paw1)
    EditText paw1;
    @BindView(R.id.paw2)
    EditText paw2;
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.bt_next)
    Button btNext;
    private SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_next)
    public void onViewClicked() {
        String na = name.getText().toString().trim();
        String psw1 = paw1.getText().toString().trim();
        String psw2 = paw2.getText().toString().trim();
        String phon = phone.getText().toString().trim();

        //判断是否为空，为空就吐司自定义提示
        if("".equals(na)||"".equals(psw1)||"".equals(psw2)||"".equals(phon)||"".equals(psw1)){
            Toast toast=Toast.makeText(RegisterActivity.this, "不能为空！", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
			/*
			 * 不为空的话，
			 * 就将得到的EditText中的值存入SharedPreferences
			*/
        }else{
            SharedPreferences sp=getSharedPreferences("zlj", MODE_PRIVATE);
            edit =sp.edit();
            edit.putString("name",na);
            edit.putString("psw",psw2);
            edit.commit();
            Intent intent=new Intent(RegisterActivity.this,PhoneActivity.class);
            RegisterActivity.this.startActivity(intent);
            finish();
        }
    }
}
