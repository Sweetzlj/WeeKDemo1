package test.route.com.weekdemo1.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import test.route.com.weekdemo1.R;

public class ForGetActivity extends AppCompatActivity {

    @BindView(R.id.et1)
    EditText et1;
    @BindView(R.id.et2)
    EditText et2;
    @BindView(R.id.bt_jump)
    Button btJump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_get);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.bt_jump)
    public void onViewClicked() {
        Intent intent = new Intent(ForGetActivity.this,LoginActivity.class);
        ForGetActivity.this.startActivity(intent);
        finish();
    }
}
