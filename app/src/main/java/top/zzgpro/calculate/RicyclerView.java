package top.zzgpro.calculate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import top.zzgpro.calculate.Adapter.RecyclerViewAdapter;
import top.zzgpro.calculate.ListItem.RecyclerItemData;

public class RicyclerView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ricycler_view);
        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.ReclyclerViewTest);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerViewAdapter recyclerViewAdapter=new RecyclerViewAdapter(this,initDatas());
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
    private ArrayList<RecyclerItemData> initDatas() {
       ArrayList<RecyclerItemData> mDatas = new ArrayList<>();
        mDatas.add(new RecyclerItemData(R.mipmap.meixi,"梅西"));
        mDatas.add(new RecyclerItemData(R.mipmap.cluo,"C罗"));
        mDatas.add(new RecyclerItemData(R.mipmap.guadi,"瓜迪奥拉"));
        mDatas.add(new RecyclerItemData(R.mipmap.debu,"德布罗意"));
        mDatas.add(new RecyclerItemData(R.mipmap.xiaobai,"小白"));
        mDatas.add(new RecyclerItemData(R.mipmap.sunke,"孙可"));
        return mDatas;
    }


}