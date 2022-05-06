package top.zzgpro.calculate.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import top.zzgpro.calculate.ListItem.RecyclerItemData;
import top.zzgpro.calculate.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<RecyclerItemData> mDatas = null;
    private LayoutInflater mInflater = null;
    public RecyclerViewAdapter(Context context, ArrayList<RecyclerItemData> datas) {
        this.mDatas = datas;
        this.mInflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=this.mInflater.inflate(R.layout.recycler_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }


    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RecyclerItemData name = mDatas.get(position);
        holder.setImageView(name.getImage());
        holder.setTitle(name.getName());
//        holder.setCentent(name.getName());

    }

    @Override
    public int getItemCount() {
         return mDatas == null ? 0 : mDatas.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private ImageView imageView;
        public TextView getTitle() {
            return title;
        }

        public void setTitle(String text) {
            this.title.setText(text);
        }

        public TextView getCentent() {
            return centent;
        }

        public void setCentent(String centent) {
            this.centent.setText(centent);
        }
        public void setImageView(int id){
            this.imageView.setImageResource(id);
        }
        private TextView centent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.title=(TextView) itemView.findViewById(R.id.title_tv);
//            this.centent=(TextView) itemView.findViewById(R.id.content_tv);
            this.imageView=(ImageView) itemView.findViewById(R.id.icon_img);

        }
    }
}

