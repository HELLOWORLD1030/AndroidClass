package top.zzgpro.calculate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xuexiang.xui.XUI;

import java.io.IOException;

import okhttp3.OkHttpClient;
import top.zzgpro.calculate.Utils.HttpUtil;

public class RobotMessage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        XUI.initTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robot_message);
        Button button=(Button) findViewById(R.id.button_sendRobot);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText InputAnswer=(EditText)findViewById(R.id.inputRobotMessage);
                if("".equals(InputAnswer.getText().toString())){
                    Toast.makeText(RobotMessage.this,"请输入文本",Toast.LENGTH_SHORT).show();
                    return;
                }
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            String response= null;
                            try {
                            String session=auth();
                            verify(session);
                            sendMessage(session,InputAnswer.getText().toString());
                            release(session);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    }).start();


            }
        });
    }
    private String auth()throws IOException{
        String response;
        String json="{\"authKey\":\"bHlxaWxvdmV5b3U=\"}";
        response = HttpUtil.PostRequest("https://web.zzgpro.top/robot/auth",json);
       JSONObject jsonObject= (JSONObject) JSON.parse(response);
      String session= jsonObject.get("session").toString();
        Log.d("QQRobot",session);
        return session;
    }
    private void verify(String session)throws IOException{
        String bind="{\"sessionKey\":"+session+",\"qq\":\"1029547281\"}";
        HttpUtil.PostRequest("https://web.zzgpro.top/robot/verify",bind);

    }
    private void sendMessage(String session,String mess)throws IOException{
        String json="{\n" +
                "    \"sessionKey\":"+session+" ,\n" +
                "    \"target\": 373692503,\n" +
                "    \"messageChain\": [\n" +
                "        { \"type\": \"Plain\", \"text\": \""+mess+"\"}\n" +
                "\n" +

                "    ]\n" +
                "}";
        Log.d("QQRobot",json);
        HttpUtil.PostRequest("https://web.zzgpro.top/robot/sendFriendMessage",json);
    }
    private void release(String session)throws IOException{
        String bind="{\"sessionKey\":"+session+",\"qq\":\"1029547281\"}";
        HttpUtil.PostRequest("https://web.zzgpro.top/robot/release",bind);
    }
}