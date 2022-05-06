package top.zzgpro.calculate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import top.zzgpro.calculate.Adapter.CustomerArrayList;

public class activity_listview extends AppCompatActivity {
    private ListView listView;
    private static final String[] strs=new String[]{
            "梅西","C罗","瓜迪奥拉","德布劳内","孙可"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String[] contents = {"Android", "demo", "Edit", "APP", "excel",
                "dota", "Button", "Circle", "excel", "back"};
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        listView=(ListView) findViewById(R.id.list_item1);
//        listView.setAdapter(new ArrayAdapter<String>(this,
//                android.R.layout., strs));
        listView.setAdapter(new CustomerArrayList(this,R.layout.listiiewitem,contents));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String content=contents[i];
                Toast.makeText(activity_listview.this,content,Toast.LENGTH_SHORT).show();
            }
        });
    }
}