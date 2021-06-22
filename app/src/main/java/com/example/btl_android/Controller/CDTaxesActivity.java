package com.example.btl_android.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.btl_android.Model.TuVung;
import com.example.btl_android.R;

import java.util.ArrayList;

public class CDTaxesActivity extends AppCompatActivity {
    SqlHelper database;
    ImageView imgAT, imgHinh;
    TextView txtTenTV, txtNghiaTV;
    ListView lvTV;
    ArrayList<TuVung> arrayTV;
    TuVungAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chu_de_taxes);
        getSupportActionBar().hide();
        lvTV = (ListView) findViewById(R.id.listviewTaxes);
        arrayTV = new ArrayList<>();
        adapter = new TuVungAdapter(CDTaxesActivity.this, R.layout.dong_tu_vung, arrayTV);
        lvTV.setAdapter(adapter);
        database = new SqlHelper(this, "hoctienganh.sqlite", null, 1);

        LayData();
        lvTV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DiaglogtheoID(arrayTV.get(position).getId());
            }
        });
    }
    private void LayData(){

        String sql = "SELECT * FROM TuVung WHERE ChuDe ='Taxes'";
        Cursor cursor = database.GetData(sql);
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String ten = cursor.getString(8);
            String nghia = cursor.getString(2);
            int srcHA = cursor.getInt(5);
            TuVung tu = new TuVung();
            tu.setId(id);
            tu.setTenTV(ten);
            tu.setNghiaTV(nghia);
            tu.setHinhAnhTV(srcHA);
//            tu.setAmthanhTV(R.drawable.volume_color);
            arrayTV.add(tu);

        }
        adapter.notifyDataSetChanged();
    }
    public void DiaglogtheoID(int id){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_tu_vung);
        dialog.getWindow().setLayout(969,1800);

        ImageView imgNutAmThanh = (ImageView) dialog.findViewById(R.id.imageAmthanhdialog);
        TextView txtTen = (TextView)dialog.findViewById(R.id.txtdialogTenTv);
        TextView txtLoaitu = (TextView) dialog.findViewById(R.id.txtLoaitu);
        TextView txtPhatAm = (TextView) dialog.findViewById(R.id.txtPhatAm);
        TextView txtCauVD = (TextView)dialog.findViewById(R.id.txtCauvidu);

        Cursor cursor = database.GetData("SELECT * FROM TuVung WHERE Id = '" + id  +"'");
        while (cursor.moveToNext()){
            String loaitu = cursor.getString(1);
            String nghia = cursor.getString(2);
            String phienam = cursor.getString(3);
            String cauvd = cursor.getString(7);
            String ten = cursor.getString(8);
            int srcAt = cursor.getInt(6);
            txtTen.setText(ten);
            txtLoaitu.setText("("+loaitu+")");
            txtPhatAm.setText(phienam);
            txtCauVD.setText(cauvd);

            imgNutAmThanh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MediaPlayer mediaPlayer = MediaPlayer.create(CDTaxesActivity.this,srcAt);
                    mediaPlayer.start();
                }
            });
        }
        dialog.show();
    }
}