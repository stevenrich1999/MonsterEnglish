package com.example.btl_android.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.btl_android.Model.NguPhap;
import com.example.btl_android.R;

import java.util.List;

public class NguPhapAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<NguPhap> listNguPhap;

    private class ViewHolderNP{
        TextView txtTenTN;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderNP holder;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null );

            holder = new ViewHolderNP();
            holder.txtTenTN = (TextView) convertView.findViewById(R.id.txtTennguphap) ;

            convertView.setTag(holder);
        } else {
            holder =(ViewHolderNP) convertView.getTag();
        }
        NguPhap nguphap = listNguPhap.get(position);
        holder.txtTenTN.setText(nguphap.getTenTL());

        return convertView;
    }
    public NguPhapAdapter(Context context, int layout, List<NguPhap> listNguPhap) {
        this.context = context;
        this.layout = layout;
        this.listNguPhap = listNguPhap;
    }
    @Override
    public int getCount() {
        return listNguPhap.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
