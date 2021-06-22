package com.example.btl_android.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.widget.Toast;

import com.example.btl_android.R;

public class MainActivity extends AppCompatActivity {

    SqlHelper database;
    Button btnHocTV, btnHocNguPhap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


//        Log.d("Hinh anh ","abide_by:"+ R.drawable.abide_by + "   AT:" +R.raw.abide_by );





        //tao database va tao bang
        database = new SqlHelper(this, "hoctienganh.sqlite", null, 1);
        database.QueryData("CREATE TABLE IF NOT EXISTS TuVung(Id INTEGER PRIMARY KEY AUTOINCREMENT,LoaiTu VARCHAR(255),Nghia VARCHAR(255),PhienAm VARCHAR(255),ChuDe VARCHAR(255),HinhAnh INT(100),AmThanh INT(100),CauVD VARCHAR(255),Ten VARCHAR(255))");
        database.QueryData("CREATE TABLE IF NOT EXISTS TuLoai(Id INTEGER PRIMARY KEY AUTOINCREMENT,TenTL VARCHAR(255) , CachSD VARCHAR(255), ViDu VARCHAR(255), ViduTiengViet VARCHAR(255) )");
        database.QueryData("CREATE TABLE IF NOT EXISTS CauTrucNP(Id INTEGER PRIMARY KEY AUTOINCREMENT,CauTruc VARCHAR(255), YNghia VARCHAR(255), ViDu VARCHAR(255), ViDuTiengViet VARCHAR(255) )");
//        database.QueryData("INSERT INTO TuVung VALUES(null,'v','nghia','phienam','chude',null,null,'hello world cauvidu','ten')");


//        String pathdb = getDatabasePath("hoctienganh.sqlite").getPath();



        btnHocTV = (Button) findViewById(R.id.btnHocTV);
        btnHocTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChuDeTuVungActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this,"Bạn đã chọn học Từ Vựng", Toast.LENGTH_SHORT).show();


            }
        });
        btnHocNguPhap = (Button) findViewById(R.id.btnHocNguPhap);
        btnHocNguPhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChuDeNguPhapActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this,"Bạn đã chọn học Ngữ Pháp", Toast.LENGTH_SHORT).show();
            }
        });



    }


}