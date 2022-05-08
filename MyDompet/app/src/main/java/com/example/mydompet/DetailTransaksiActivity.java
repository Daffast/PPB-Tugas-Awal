package com.example.mydompet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mydompet.ui.home.HomeViewModel;

public class DetailTransaksiActivity extends AppCompatActivity {
  ImageView mainImageView;
  TextView namaTransaksi, nominalTransaksi, tanggalTransaksi, keterangan, jenisTransaksi;
  private HomeViewModel homeViewModel;
  Button deleteButton;

  String data1, data3, data4, data5;
  int myImage, data2;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail_transaksi);

    deleteButton = findViewById(R.id.buttonDelete);
    mainImageView = findViewById(R.id.mainImageView);
    namaTransaksi = findViewById(R.id.tittleTransaksi);
    nominalTransaksi = findViewById(R.id.nominalTransaksi);
    tanggalTransaksi = findViewById(R.id.tanggalTransaksi);
    keterangan = findViewById(R.id.keteranganTransaksi);
    jenisTransaksi = findViewById(R.id.jenisTransaksi);

    Intent intent = getIntent();

    Transaksi transaksi = intent.getParcelableExtra("Transaksi");

    myImage = transaksi.getMyImage();
    data1 = transaksi.getNamaTransaksi();
    data2 = transaksi.getNominalTransaksi();
    data3 = transaksi.getTanggal();
    data4 = transaksi.getKeterangan();
    data5 = transaksi.getJenisTransaksi();

    mainImageView.setImageResource(myImage);
    namaTransaksi.setText(data1);
    nominalTransaksi.setText(Integer.toString(data2));
    tanggalTransaksi.setText(data3);
    keterangan.setText(data4);
    jenisTransaksi.setText(data5);

    homeViewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(HomeViewModel.class);
    deleteButton.setOnClickListener(View -> {
      homeViewModel.delete(data1);
      finish();
    });
  }

}