package com.example.mydompet.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydompet.R;

class TransaksiViewHolder extends RecyclerView.ViewHolder {

  private final TextView namaTransaksi, nominalTransaksi;
  private final ImageView myImage;
  ConstraintLayout detailButton;

  private TransaksiViewHolder(View itemView) {
    super(itemView);
    namaTransaksi = itemView.findViewById(R.id.nama_transaksi);
    nominalTransaksi = itemView.findViewById(R.id.nominal_transaksi);
    myImage = itemView.findViewById(R.id.myImageView);
    detailButton = itemView.findViewById(R.id.mainLayout);
  }

  public void bind(String namaTransaksi, int nominalTransaksi, int myImage) {
    this.namaTransaksi.setText(namaTransaksi);
    this.nominalTransaksi.setText(Integer.toString(nominalTransaksi));
    this.myImage.setImageResource(myImage);
  }

  static TransaksiViewHolder create(ViewGroup parent) {
    View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.my_row, parent, false);
    return new TransaksiViewHolder(view);
  }
}
