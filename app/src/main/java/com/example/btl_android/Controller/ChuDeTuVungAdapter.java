package com.example.btl_android.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.btl_android.Model.HinhAnhChuDe;
import com.example.btl_android.R;

import java.util.List;

public class ChuDeTuVungAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<HinhAnhChuDe> hinhAnhChuDeList;

    public ChuDeTuVungAdapter(Context context, int layout, List<HinhAnhChuDe> hinhAnhChuDeList) {
        this.context = context;
        this.layout = layout;
        this.hinhAnhChuDeList = hinhAnhChuDeList;
    }

    public class ViewHolder{
        ImageView imageChuDe;
    }
    @Override
    public int getCount() {
        return hinhAnhChuDeList.size();
    }

    @Override
    public Object getItem(int position) {

        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);

            holder.imageChuDe = (ImageView) convertView.findViewById(R.id.imageviewChuDeTuVung);
            holder.imageChuDe.setScaleType(ImageView.ScaleType.FIT_CENTER);
//            holder.imageChuDe.setLayoutParams(new Gallery.LayoutParams(200,150));
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        HinhAnhChuDe hinhAnhChuDe = hinhAnhChuDeList.get(position);
        holder.imageChuDe.setImageResource(hinhAnhChuDe.getHinhChuDe());

        return convertView;
    }
}
