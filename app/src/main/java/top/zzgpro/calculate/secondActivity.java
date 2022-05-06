package top.zzgpro.calculate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class secondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button button=(Button) findViewById(R.id.button_jump1);
        EditText editText=(EditText) findViewById(R.id.input1);
        TextView textView=(TextView)findViewById(R.id.showTip);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Button CheckButton=(Button) findViewById(R.id.cheakButton);
        CheckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String InputChar= editText.getText().toString();
               if("".equals(InputChar)){
                    textView.setText("请输入您的的名字");
               }else{
                   textView.setText(InputChar+" 您好");
               }
            }
        });

    }
}