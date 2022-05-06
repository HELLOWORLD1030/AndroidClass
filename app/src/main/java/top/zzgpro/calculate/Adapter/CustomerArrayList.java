package top.zzgpro.calculate.Adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import top.zzgpro.calculate.R;

public class CustomerArrayList extends ArrayAdapter {
    private Activity mContext = null; // 上下文环境
    private int mResourceId; // 列表项布局资源ID
    private String[] mItems; // 列表内容数组

    /**
     *
     * @param context 将Activity传入
     * @param resource Item的资源id
     * @param objects 要渲染的数据
     */
    public CustomerArrayList(@NonNull Activity context, int resource, @NonNull Object[] objects) {
        super(context, resource, objects);
        mContext = context;
        mResourceId = resource;
        mItems = (String[]) objects;

    }

    /**
     *
     * @param position 每一个列表项的位置
     * @param convertView 用来做缓存
     * @param parent 父
     * @return
     */
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.i("selelistw",String.valueOf(mResourceId));
        View itemView=null;
//       判断convertview是否为空，若为空才重新加载view，提高性能
        if(convertView==null){
            // 获取LayoutInflater对象
            LayoutInflater inflater = mContext.getLayoutInflater();
            // 装载列表项视图
             itemView = inflater.inflate(mResourceId, null);
        }else{
            itemView=convertView;
        }


        // 获取列表项之组件
        TextView contentTv = (TextView) itemView.findViewById(R.id.content_tv);
        ImageView letterImg = (ImageView) itemView.findViewById(R.id.letter_img);

        // 取出要显示的数据
        String content = mItems[position].trim();

        // 给TextView设置显示值
        contentTv.setText(content);
        // 根据内容首字母判断要显示的图标
        if(content.startsWith("a") || content.startsWith("A")) {
            letterImg.setImageResource(R.drawable.bg1);
        } else if(content.startsWith("b") || content.startsWith("B")) {
            letterImg.setImageResource(R.drawable.bg1);
        } else if(content.startsWith("c") || content.startsWith("C")) {
            letterImg.setImageResource(R.drawable.bg1);
        } else if(content.startsWith("d") || content.startsWith("D")) {
            letterImg.setImageResource(R.drawable.bg1);
        } else if(content.startsWith("e") || content.startsWith("E")) {
            letterImg.setImageResource(R.drawable.bg1);
        }

        // 返回列表项视图
        return itemView;
    }

}
