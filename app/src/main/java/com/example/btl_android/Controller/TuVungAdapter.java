package com.example.btl_android.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.btl_android.Model.TuVung;
import com.example.btl_android.R;


import java.util.List;

public class TuVungAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<TuVung> listTuVung;

    private class ViewHolderTV{
        ImageView imgHinh;
        TextView txtTenTV, txtNghiaTV;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolderTV holderTV;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null );

            holderTV = new ViewHolderTV();
            holderTV.txtTenTV = (TextView) convertView.findViewById(R.id.textviewTenTV) ;
            holderTV.txtNghiaTV = (TextView) convertView.findViewById(R.id.textviewNghiaTV) ;
            holderTV.imgHinh = (ImageView) convertView.findViewById(R.id.imageHinhTV) ;


            convertView.setTag(holderTV);
        } else {
            holderTV =(ViewHolderTV) convertView.getTag();
        }

        TuVung tuVung = listTuVung.get(position);
        holderTV.txtTenTV.setText(tuVung.getTenTV());
        holderTV.txtNghiaTV.setText(tuVung.getNghiaTV());
        holderTV.imgHinh.setImageResource(tuVung.getHinhAnhTV());


        return convertView;
    }
    public TuVungAdapter(Context context, int layout, List<TuVung> listTuVung) {
        this.context = context;
        this.layout = layout;
        this.listTuVung = listTuVung;
    }

    @Override
    public int getCount() {
        return listTuVung.size();
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
