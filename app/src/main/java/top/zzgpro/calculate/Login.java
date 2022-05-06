package top.zzgpro.calculate;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.xuexiang.xui.XUI;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        XUI.initTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        EnableRegisterButton();
    }
        private void EnableRegisterButton(){
        TextView register=(TextView) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Login.this, Register2.class);
                startActivityForResult(intent,1);

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(1==resultCode){
             Bundle bundle= data.getBundleExtra("bundle");
             String name=bundle.getString("username");
             String password=bundle.getString("password");
            Log.i("RegisterCallBack",name+" "+password);
            EditText usernameInput=(EditText) findViewById(R.id.username);
            EditText passwordInput=(EditText) findViewById(R.id.password);
            usernameInput.setText(name);
            passwordInput.setText(password);
        }
    }

}