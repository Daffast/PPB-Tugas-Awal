package com.example.mydompet.ui.home;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mydompet.Transaksi;

import java.util.List;

public class HomeViewModel extends AndroidViewModel {

  private TransaksiRepository mRepository;

  private final LiveData<List<Transaksi>> mAllTransaksi;

  public HomeViewModel(Application application) {
    super(application);
    mRepository = new TransaksiRepository(application);
    mAllTransaksi = mRepository.getAllTransaksi();
  }

  public LiveData<List<Transaksi>> getAllTransaksi() {
    return mAllTransaksi;
  }

  public void insert(Transaksi transaksi) {
    mRepository.insert(transaksi);
  }

  public void delete(String nama_transaksi) {
    mRepository.delete(nama_transaksi);
  }
}