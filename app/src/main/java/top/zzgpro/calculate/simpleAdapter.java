package top.zzgpro.calculate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class simpleAdapter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter);
        LoadListView();
    }
    private void LoadListView(){
        ListView listView=(ListView) findViewById(R.id.simplelistview);
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,
                this.getItem(),
                R.layout.baseadapteritem,
                new String[]{"img","title","info"},
                new int[]{R.id.icon_img,R.id.info_tv,R.id.title_tv});
        listView.setAdapter(simpleAdapter);
    }
    private List<Map<String,Object>> getItem(){
        List<Map<String,Object>> list=new ArrayList<>();
        Map<String,Object> map=new HashMap<>();
        map.put("img",R.drawable.bg1);
        map.put("title","zzg1");
        map.put("info","123");
        list.add(map);
        map=new HashMap<>();
        map.put("img",R.drawable.bg1);
        map.put("title","zzg123");
        map.put("info","123456");
        list.add(map);
        map=new HashMap<>();
        map.put("img",R.drawable.bg1);
        map.put("title","zzg456");
        map.put("info","123455644");
        list.add(map);
        map=new HashMap<>();
        map.put("img",R.drawable.bg1);
        map.put("title","zzg456sss");
        map.put("info","123455644ssss");
        list.add(map);
        return list;
    }
}