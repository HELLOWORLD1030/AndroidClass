package top.zzgpro.calculate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class activity_third extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        ImageView imageView=(ImageView) findViewById(R.id.imageview1);
        ImageButton imageButton=(ImageButton)findViewById(R.id.imgaebutton1);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               int test =imageButton.getVisibility();
               if(test==View.VISIBLE){
                   imageButton.setVisibility(View.INVISIBLE);
               }else{
                   imageButton.setVisibility(View.VISIBLE);
               }
            }
        });
    }
}