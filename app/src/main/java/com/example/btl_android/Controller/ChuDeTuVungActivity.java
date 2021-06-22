package com.example.btl_android.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.btl_android.Model.HinhAnhChuDe;
import com.example.btl_android.R;

import java.util.ArrayList;

public class ChuDeTuVungActivity extends AppCompatActivity {
    GridView gvHinhChuDe;
    ArrayList<HinhAnhChuDe> arrayHA;
    ChuDeTuVungAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chu_de_tu_vung);
        getSupportActionBar().hide();

        AnhXa();

        adapter = new ChuDeTuVungAdapter(ChuDeTuVungActivity.this,R.layout.anh_chu_de_tu_vung,arrayHA);
        gvHinhChuDe.setAdapter(adapter);
        gvHinhChuDe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(arrayHA.get(position).getTenHinh().equals("Contracts")){
                    Intent intent = new Intent(ChuDeTuVungActivity.this,CDContractsActivity.class);
                    startActivity(intent);
                }
                if(arrayHA.get(position).getTenHinh().equals("Banking")){
                    Intent intent = new Intent(ChuDeTuVungActivity.this,CDBankingActivity.class);
                    startActivity(intent);
                }
                if(arrayHA.get(position).getTenHinh().equals("Taxes")){
                    Intent intent = new Intent(ChuDeTuVungActivity.this,CDTaxesActivity.class);
                    startActivity(intent);
                }
                if(arrayHA.get(position).getTenHinh().equals("Warranties")){
                    Intent intent = new Intent(ChuDeTuVungActivity.this,CDWarrantiesActivity.class);
                    startActivity(intent);
                }
                Toast.makeText(ChuDeTuVungActivity.this,"Bạn chọn chủ đề "+arrayHA.get(position).getTenHinh(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void AnhXa(){
        gvHinhChuDe = (GridView) findViewById(R.id.gridviewChuDeTV);
        arrayHA = new ArrayList<>();

        arrayHA.add(new HinhAnhChuDe("Contracts", R.drawable.contracts));
        arrayHA.add(new HinhAnhChuDe("Banking", R.drawable.banking));
        arrayHA.add(new HinhAnhChuDe("Taxes", R.drawable.taxes));
        arrayHA.add(new HinhAnhChuDe("Warranties", R.drawable.warranties));


    }
}