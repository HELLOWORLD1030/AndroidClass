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



        JumpToLabTwo();
        JumpToBaseListView();
        JumpToSimpleListView();
        JumpToLabThree();
        JumpToListView();
        JumpToRecyclerView();
        JumpToRecyclerView2();
        JumpToLab5();
        JumpToLab52();
        JumpToLab6();
        JumpToImage();
        JumpToMusic();

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
    private void JumpToBaseListView(){
        Button button=(Button) findViewById(R.id.button_jumpBaseList);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,baseListView.class);
                startActivity(intent);
            }
        });
    }
    private void JumpToSimpleListView(){
        Button button=(Button) findViewById(R.id.button_jumpSimpleList);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,simpleAdapter.class);
                startActivity(intent);
            }
        });
    }
    private void JumpToLabTwo(){
        Button jumpBun=(Button)findViewById(R.id.button_jump);
        jumpBun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,secondActivity.class);
                startActivity(intent);
            }
        });
    }
    private void JumpToLabThree(){
        Button jumpBun1=(Button)findViewById(R.id.button_jump1);

        jumpBun1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,three.class);
                startActivity(intent);
            }
        });
    }
    private void JumpToListView(){
        Button jumpBunListView=(Button)findViewById(R.id.button_jumpListView);

        jumpBunListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,activity_listview.class);
                startActivity(intent);
            }
        });
    }
    private void JumpToRecyclerView(){
        Button jumpBunListView=(Button)findViewById(R.id.button_jumpRecyclerView);

        jumpBunListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, RicyclerView.class);
                startActivity(intent);
            }
        });
    }
    private void JumpToRecyclerView2(){
        Button jumpBunListView=(Button)findViewById(R.id.button_jumpRecyclerView2);

        jumpBunListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, lab42.class);
                startActivity(intent);
            }
        });
    }
    private void JumpToLab5(){
        Button jumpBunListView=(Button)findViewById(R.id.button_jumplab5);

        jumpBunListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, lab5.class);
                startActivity(intent);
            }
        });
    }
    private void JumpToLab52() {
        Button jumpBunListView=(Button)findViewById(R.id.button_jumplab52);

        jumpBunListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, lab52.class);
                startActivity(intent);
            }
        });
    }
    private void JumpToLab6() {
        Button jumpBunListView=(Button)findViewById(R.id.button_jumplab6);

        jumpBunListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });
    }
    private void JumpToImage() {
        Button jumpBunListView=(Button)findViewById(R.id.button_jumpImage);

        jumpBunListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, activity_third.class);
                startActivity(intent);
            }
        });
    }
    private void JumpToMusic() {
        Button jumpBunListView=(Button)findViewById(R.id.button_jumpMusic);

        jumpBunListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, MusicPlayer.class);
                startActivity(intent);
            }
        });
    }
}