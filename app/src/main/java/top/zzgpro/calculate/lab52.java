package top.zzgpro.calculate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class lab52 extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private  int item=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab52);
        int[] id={R.id.chk1,R.id.chk2,R.id.chk3,R.id.chk4};
        for (int i : id) {
            ((CheckBox)findViewById(i)).setOnCheckedChangeListener(this);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        int visionable;
        if(b){
            item++;
            visionable= View.VISIBLE;
        }else{
            item--;
            visionable=View.GONE;
        }
        switch (compoundButton.getId()){
            case R.id.chk1:
                findViewById(R.id.output1).setVisibility(visionable);
                break;
            case R.id.chk2:
                findViewById(R.id.output2).setVisibility(visionable);
                break;
            case R.id.chk3:
                findViewById(R.id.output3).setVisibility(visionable);
                break;
            case R.id.chk4:
                findViewById(R.id.output4).setVisibility(visionable);
                break;

        }
        String msg;
        if(item>0){
            msg="您点的餐如下:";
        }else{
            msg="请点餐";
        }
        ((TextView)findViewById(R.id.showOrder)).setText(msg);

    }
}