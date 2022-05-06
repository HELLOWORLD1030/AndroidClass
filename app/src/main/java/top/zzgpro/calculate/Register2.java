package top.zzgpro.calculate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.Toast;

import com.xuexiang.xui.XUI;

public class Register2 extends AppCompatActivity {
    private String Account;
    private String Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        XUI.initTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        EnableRegisterButtonClickHandler();
    }
    private void EnableRegisterButtonClickHandler(){
        Button registerButton=(Button) findViewById(R.id.register);
        registerButton.setOnClickListener(new RegisterButtonClickHandler());
    }
    class RegisterButtonClickHandler implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if(!checkInput()){
                Toast.makeText(Register2.this,"请输入账户名或密码",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(Register2.this,"register finished",Toast.LENGTH_SHORT).show();
                Bundle bundle=new Bundle();
                bundle.putString("username",Account);
                bundle.putString("password",Password);
                Intent intent=new Intent(Register2.this,Login.class);
                intent.putExtra("bundle",bundle);
                setResult(1,intent);
                Register2.this.finish();

            }
        }
    }
    private boolean checkInput(){
        EditText account=(EditText) findViewById(R.id.username);
        EditText password=(EditText) findViewById(R.id.password);
        String AccountStr=account.getText().toString();
        String PasswordStr=password.getText().toString();
        if("".equals( AccountStr)||"".equals(PasswordStr)){
            return false;
        }
        Account=AccountStr;
        Password=PasswordStr;
        return true;
    }
}