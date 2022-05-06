package top.zzgpro.calculate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class lab5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab5);
    }
    public void takeOrder(View v){
        CheckBox box;
        StringBuilder builder=new StringBuilder();
        int[] id={R.id.chk1,R.id.chk2,R.id.chk3,R.id.chk4};
        for (int i : id) {
            box=(CheckBox) findViewById(i);
            if(box.isChecked()) {
                builder.append("\n").append(box.getText());
            }
        }
        if(builder.length()>0){
            ((TextView)findViewById(R.id.showOrder)).setText("您订购的物品为："+builder.toString());
        }else{
            ((TextView)findViewById(R.id.showOrder)).setText("请点餐");
        }
    }
}