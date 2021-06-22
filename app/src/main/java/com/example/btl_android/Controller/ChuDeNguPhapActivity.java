package com.example.btl_android.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.btl_android.Model.HinhAnhCDNP;
import com.example.btl_android.R;

import java.util.ArrayList;

public class ChuDeNguPhapActivity extends AppCompatActivity {
    GridView gvHinhNP;
    ArrayList<HinhAnhCDNP> arrayHANP;
    ChuDeNguPhapAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chu_de_ngu_phap);
        getSupportActionBar().hide();

        AnhXa();
        adapter = new ChuDeNguPhapAdapter(ChuDeNguPhapActivity.this,R.layout.anh_chu_de_ngu_phap,arrayHANP);
        gvHinhNP.setAdapter(adapter);
        gvHinhNP.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ChuDeNguPhapActivity.this,arrayHANP.get(position).getTenHinh(),Toast.LENGTH_SHORT).show();
                if(arrayHANP.get(position).getTenHinh().equals("Từ loại")){
                    Intent intent = new Intent(ChuDeNguPhapActivity.this, TuLoaiActivity.class);
                    startActivity(intent);
                }
                if(arrayHANP.get(position).getTenHinh().equals("Cấu trúc ngữ pháp cơ bản")){
                    Intent intent = new Intent(ChuDeNguPhapActivity.this, CauTrucActivity.class);
                    startActivity(intent);
                }
            }
        });


    }
    private void AnhXa(){
        gvHinhNP = (GridView)findViewById(R.id.gridviewChuDeNP);
        arrayHANP = new ArrayList<>();
        arrayHANP.add(new HinhAnhCDNP("Từ loại", R.drawable.tuloai));
        arrayHANP.add(new HinhAnhCDNP("Cấu trúc ngữ pháp cơ bản", R.drawable.cau_truc_tieng_anh));
    }

}