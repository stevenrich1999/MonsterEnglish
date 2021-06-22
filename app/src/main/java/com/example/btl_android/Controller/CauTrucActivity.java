package com.example.btl_android.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.btl_android.Model.NguPhap;
import com.example.btl_android.R;

import java.util.ArrayList;

public class CauTrucActivity extends AppCompatActivity {

    SqlHelper database;
    TextView txtTenNP;
    ListView lvNP;
    ArrayList<NguPhap> arrayNP;
    NguPhapAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau_truc);
        getSupportActionBar().hide();
        lvNP = (ListView) findViewById(R.id.listviewcautruc);

        arrayNP = new ArrayList<>();
        adapter = new NguPhapAdapter(CauTrucActivity.this, R.layout.dong_ngu_phap, arrayNP);
        lvNP.setAdapter(adapter);
        database = new SqlHelper(this, "hoctienganh.sqlite", null, 1);
        LayData();
        lvNP.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DiaglogtheoID(arrayNP.get(position).getId());
            }
        });

    }
    private void LayData(){
        String sql = "SELECT * FROM CauTrucNP ";
        Cursor cursor = database.GetData(sql);
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String ten = cursor.getString(1);
            String ynghia = cursor.getString(2);
            String vidu = cursor.getString(3);
            String viduTiengViet = cursor.getString(4);
            NguPhap np = new NguPhap();
            np.setId(id);
            np.setTenTL(ten);
            np.setCachSD(ynghia);
            np.setViDu(vidu);
            np.setViDuTiengViet(viduTiengViet);
            arrayNP.add(np);

        }
        adapter.notifyDataSetChanged();
    }
    public void DiaglogtheoID(int id){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_ngu_phap);
        dialog.getWindow().setLayout(969,1800);


        TextView txtTen = (TextView)dialog.findViewById(R.id.txtdilogtennguphap);
        TextView txtYNghiaCachSD = (TextView) dialog.findViewById(R.id.txtYnghiaCachsudung);
        TextView txtVidu = (TextView) dialog.findViewById(R.id.txtdialogViduNP);
        TextView txtViduTiengViet = (TextView)dialog.findViewById(R.id.txtdialogViduNPTV);

        Cursor cursor = database.GetData("SELECT * FROM CauTrucNP WHERE Id = '" + id  +"'");
        while (cursor.moveToNext()){
            String ten = cursor.getString(1);
            String ynghicachSD = cursor.getString(2);
            String vidu = cursor.getString(3);
            String viduTV = cursor.getString(4);


            txtTen.setText(ten);
            txtYNghiaCachSD.setText(ynghicachSD);
            txtVidu.setText(vidu);
            txtViduTiengViet.setText(viduTV);

        }
        dialog.show();
    }
}