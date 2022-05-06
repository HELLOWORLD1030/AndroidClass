package top.zzgpro.calculate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class three extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        Button addone=(Button) findViewById(R.id.addone);
        TextView showNumber=(TextView)findViewById(R.id.showNumber);
        addone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer num=Integer.parseInt(showNumber.getText().toString());
                showNumber.setText((++num).toString());
            }
        });
    }
}