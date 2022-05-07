package top.zzgpro.calculate;

import androidx.appcompat.app.AppCompatActivity;
import top.zzgpro.calculate.RicyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import top.zzgpro.calculate.Enum.CalculateTag;
import top.zzgpro.calculate.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {
    Random random=new Random(System.currentTimeMillis());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GenRandomInt();
        Button btnTest = (Button) findViewById(R.id.button_send);
        EditText AutoFillOne=(EditText)findViewById(R.id.AutoFillNumOne);
        EditText AutoFillTwo=(EditText)findViewById(R.id.AutoFillNumTwo);
        AutoFillOne.setKeyListener(null);
        AutoFillTwo.setKeyListener(null);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//
//                Toast.makeText(MainActivity.this, "生成", Toast.LENGTH_SHORT).show();
                CheckAnswer();
            }
        });

        EnableButton(R.id.button_jumpMusic,MusicPlayer.class);
        EnableButton(R.id.button_jumpImage,activity_third.class);
        EnableButton(R.id.button_jumplab6,Login.class);
        EnableButton(R.id.button_jumplab5,lab5.class);
        EnableButton(R.id.button_jumplab52,lab52.class);
        EnableButton(R.id.button_jumpRecyclerView2,lab42.class);
        EnableButton(R.id.button_jumpRecyclerView,RicyclerView.class);
        EnableButton(R.id.button_jumpListView,activity_listview.class);
        EnableButton(R.id.button_jump1,three.class);
        EnableButton(R.id.button_jumpSimpleList,simpleAdapter.class);
        EnableButton(R.id.button_jumpBaseList,baseListView.class);
        EnableButton(R.id.button_jump,secondActivity.class);
        EnableButton(R.id.button_jumpRobot,RobotMessage.class);



    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_title:
                Toast.makeText(MainActivity.this,"add button clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_title:
                Toast.makeText(MainActivity.this,"remove button clicked",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    private void setNumber(int NumOne, int NumTwo, String Tag){
        EditText AutoFillOne=(EditText)findViewById(R.id.AutoFillNumOne);
        EditText AutoFillTwo=(EditText)findViewById(R.id.AutoFillNumTwo);
        TextView opTag=(TextView)findViewById(R.id.operationTag);
        AutoFillOne.setText(String.valueOf(NumOne));
        AutoFillTwo.setText(String.valueOf(NumTwo));
        opTag.setText(Tag);
    }
    private void GenRandomInt(){
        int NumOne=random.nextInt(101);
        int NumTwo=random.nextInt(101);
        int Flag=random.nextInt(4);
        String tag= CalculateTag.ADD.getTag(Flag);
        setNumber(NumOne,NumTwo,tag);



    }
    private void CheckAnswer(){
        boolean isCorrect=false;
        EditText AutoFillOne=(EditText)findViewById(R.id.AutoFillNumOne);
        EditText AutoFillTwo=(EditText)findViewById(R.id.AutoFillNumTwo);
        EditText InputAnswer=(EditText)findViewById(R.id.edit_message);
        TextView opTag=(TextView)findViewById(R.id.operationTag);
        int NumOne=Integer.parseInt(AutoFillOne.getText().toString());
        int NumTwo=Integer.parseInt(AutoFillTwo.getText().toString());
        String Tag=opTag.getText().toString();
        String inputAn= InputAnswer.getText().toString();
        if("".equals(inputAn)){
            Toast.makeText(MainActivity.this, "请输入答案", Toast.LENGTH_SHORT).show();
            return ;
        }
        Integer integerAn=Integer.parseInt(inputAn);
        switch (Tag){
            case "+":
                isCorrect= integerAn.equals(NumOne+NumTwo);
                break;
            case "-":
                isCorrect=integerAn.equals(NumOne-NumTwo);
                break;
            case "*":
                isCorrect=integerAn.equals(NumOne*NumTwo);
                break;
            case "/":
                isCorrect=integerAn.equals(NumOne/NumTwo);
            break;
        }
        if(isCorrect){
            GenRandomInt();
            Toast.makeText(MainActivity.this, "回答正确", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivity.this, "回答错误", Toast.LENGTH_SHORT).show();
        }


    }

    private void EnableButton(int id,Class purpose){
        Button button=(Button) findViewById(id);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,purpose);
                startActivity(intent);
            }
        });
    }
}