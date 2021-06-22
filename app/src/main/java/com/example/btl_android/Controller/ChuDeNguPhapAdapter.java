package com.example.btl_android.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.btl_android.Model.HinhAnhCDNP;
import com.example.btl_android.R;
import com.example.btl_android.Controller.ChuDeNguPhapAdapter;
import java.util.List;

public class ChuDeNguPhapAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<HinhAnhCDNP> hinhAnhNPList;

    public ChuDeNguPhapAdapter(Context context, int layout, List<HinhAnhCDNP> hinhAnhNPList) {
        this.context = context;
        this.layout = layout;
        this.hinhAnhNPList = hinhAnhNPList;
    }

    public class ViewHolderCDNP{
        ImageView imageCDNP;
    }
    @Override
    public int getCount() {
        return hinhAnhNPList.size();
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
        ViewHolderCDNP holder;
        if(convertView == null){
            holder = new ViewHolderCDNP();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);

            holder.imageCDNP = (ImageView) convertView.findViewById(R.id.imageviewChuDeNP);// dung chung 1 cái layout nhỏ ý
            convertView.setTag(holder);
        }else {
            holder = (ViewHolderCDNP) convertView.getTag();
        }

        HinhAnhCDNP hinhAnhChuDe = hinhAnhNPList.get(position);
        holder.imageCDNP.setImageResource(hinhAnhChuDe.getHinhChuDeNP());
        return convertView;
    }
}
