package com.example.mydompet.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.mydompet.DetailTransaksiActivity;
import com.example.mydompet.Transaksi;

public class TransaksiListAdapter extends ListAdapter<Transaksi, TransaksiViewHolder> {

  Context context;

  protected TransaksiListAdapter(@NonNull DiffUtil.ItemCallback<Transaksi> diffCallback, Context context) {
    super(diffCallback);
    this.context = context;
  }

  @NonNull
  @Override
  public TransaksiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return TransaksiViewHolder.create(parent);
  }

  @Override
  public void onBindViewHolder(@NonNull TransaksiViewHolder holder, int position) {
    Transaksi current = getItem(position);
    holder.bind(current.getNamaTransaksi(), current.getNominalTransaksi(), current.getMyImage());
    holder.detailButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(context, DetailTransaksiActivity.class);
        intent.putExtra("Transaksi", current);
        context.startActivity(intent);
      }
    });
  }

  static class TransaksiDiff extends DiffUtil.ItemCallback<Transaksi> {

    @Override
    public boolean areItemsTheSame(@NonNull Transaksi oldItem, @NonNull Transaksi newItem) {
      return oldItem == newItem;
    }

    @Override
    public boolean areContentsTheSame(@NonNull Transaksi oldItem, @NonNull Transaksi newItem) {
      return oldItem.getNamaTransaksi().equals(newItem.getNamaTransaksi());
    }
  }
}
