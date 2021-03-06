package top.zzgpro.calculate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import top.zzgpro.calculate.Adapter.CustomBaseAdapter;
import top.zzgpro.calculate.ListItem.BaseAdapterItem;

public class baseListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_list_view);
        LoadBaseAdapter();
    }
    private void LoadBaseAdapter(){
        ListView listView=findViewById(R.id.baselistview);
        listView.setAdapter(new CustomBaseAdapter(this,this.getItem(),R.layout.baseadapteritem));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                BaseAdapterItem item=getItem().get(i);
                Toast.makeText(baseListView.this,item.getTitle(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    private List<BaseAdapterItem> getItem(){
        List<BaseAdapterItem> items=new ArrayList<>();
        items.add(new BaseAdapterItem(R.drawable.bg1,"zzg","123"));
        items.add(new BaseAdapterItem(R.drawable.bg1,"zzg1","12314"));
       items.add( new BaseAdapterItem(R.drawable.bg1,"zzg2","1234123"));
       items.add(new BaseAdapterItem(R.drawable.bg1,"zzg2dsds","12341dsds23"));
       return items;

    }
}