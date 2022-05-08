package com.example.mydompet.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydompet.R;
import com.example.mydompet.Transaksi;

public class HomeFragment extends Fragment {

  private HomeViewModel homeViewModel;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getParentFragmentManager().setFragmentResultListener("dataTransaksi", this, new FragmentResultListener() {
      @Override
      public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
        String tanggalTransaksi = bundle.getString("tanggalTransaksi");
        String jenisTransaksi = bundle.getString("jenisTransaksi");
        String namaTransaksi = bundle.getString("namaTransaksi");
        int nominalTransaksi = bundle.getInt("nominalTransaksi");
        String keteranganTransaksi = bundle.getString("keteranganTransaksi");

        if (nominalTransaksi >= 0) {
          Transaksi transaksi = new Transaksi(namaTransaksi, nominalTransaksi, R.drawable.ic_pemasukan, keteranganTransaksi, tanggalTransaksi, jenisTransaksi);
          homeViewModel.insert(transaksi);
        } else {
          Transaksi transaksi = new Transaksi(namaTransaksi, nominalTransaksi, R.drawable.ic_pengeluaran, keteranganTransaksi, tanggalTransaksi, jenisTransaksi);
          homeViewModel.insert(transaksi);
        }
      }
    });
  }

  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
    View root = inflater.inflate(R.layout.fragment_home, container, false);

    final TransaksiListAdapter adapter = new TransaksiListAdapter(new TransaksiListAdapter.TransaksiDiff(), getContext());

    RecyclerView recyclerView = root.findViewById(R.id.recyclerView);
    recyclerView.setAdapter(adapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    homeViewModel.getAllTransaksi().observe(getViewLifecycleOwner(), transaksis -> {
      adapter.submitList(transaksis);
    });

    return root;
  }
}