package com.example.mydompet.ui.home;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.mydompet.Transaksi;

import java.util.List;

class TransaksiRepository {

  private TransaksiDao mTransaksiDao;
  private LiveData<List<Transaksi>> mAllTransaksi;

  // Note that in order to unit test the WordRepository, you have to remove the Application
  // dependency. This adds complexity and much more code, and this sample is not about testing.
  // See the BasicSample in the android-architecture-components repository at
  // https://github.com/googlesamples
  TransaksiRepository(Application application) {
    TransaksiRoomDatabase db = TransaksiRoomDatabase.getDatabase(application);
    mTransaksiDao = db.transaksiDao();
    mAllTransaksi = mTransaksiDao.getTransaksiList();
  }

  // Room executes all queries on a separate thread.
  // Observed LiveData will notify the observer when the data has changed.
  LiveData<List<Transaksi>> getAllTransaksi() {
    return mAllTransaksi;
  }

  // You must call this on a non-UI thread or your app will throw an exception. Room ensures
  // that you're not doing any long running operations on the main thread, blocking the UI.
  void insert(Transaksi transaksi) {
    TransaksiRoomDatabase.databaseWriteExecutor.execute(() -> {
      mTransaksiDao.insert(transaksi);
    });
  }

  void delete(String nama_transaksi) {
    TransaksiRoomDatabase.databaseWriteExecutor.execute(() -> {
      mTransaksiDao.delete(nama_transaksi);
    });
  }
}
