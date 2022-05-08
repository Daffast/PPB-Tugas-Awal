package com.example.mydompet;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tabel_transaksi")
public class Transaksi implements Parcelable {

  @PrimaryKey
  @NonNull
  @ColumnInfo(name = "nama_transaksi")
  private String namaTransaksi;

  @ColumnInfo(name = "nominal_transaksi")
  private int nominalTransaksi;

  @ColumnInfo(name = "keterangan")
  private String keterangan;

  @ColumnInfo(name = "tanggal")
  private String tanggal;

  @ColumnInfo(name = "jenis_transaksi")
  private String jenisTransaksi;

  @ColumnInfo(name = "image")
  private int myImage;

  public Transaksi(@NonNull String namaTransaksi, int nominalTransaksi, int myImage, String keterangan, String tanggal, String jenisTransaksi) {
    this.namaTransaksi = namaTransaksi;
    this.nominalTransaksi = nominalTransaksi;
    this.myImage = myImage;
    this.keterangan = keterangan;
    this.tanggal = tanggal;
    this.jenisTransaksi = jenisTransaksi;
  }

  public Transaksi(Parcel in) {
    namaTransaksi = in.readString();
    nominalTransaksi = in.readInt();
    keterangan = in.readString();
    tanggal = in.readString();
    jenisTransaksi = in.readString();
    myImage = in.readInt();
  }

  public String getNamaTransaksi() {
    return namaTransaksi;
  }

  public void setNamaTransaksi(String namaTransaksi) {
    this.namaTransaksi = namaTransaksi;
  }

  public int getNominalTransaksi() {
    return nominalTransaksi;
  }

  public void setNominalTransaksi(int nominalTransaksi) {
    this.nominalTransaksi = nominalTransaksi;
  }

  public int getMyImage() {
    return myImage;
  }

  public void setMyImage(int myImage) {
    this.myImage = myImage;
  }

  public String getKeterangan() {
    return keterangan;
  }

  public void setKeterangan(String keterangan) {
    this.keterangan = keterangan;
  }

  public String getTanggal() {
    return tanggal;
  }

  public void setTanggal(String tanggal) {
    this.tanggal = tanggal;
  }

  public String getJenisTransaksi() {
    return jenisTransaksi;
  }

  public void setJenisTransaksi(String jenisTransaksi) {
    this.jenisTransaksi = jenisTransaksi;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(namaTransaksi);
    dest.writeInt(nominalTransaksi);
    dest.writeString(keterangan);
    dest.writeString(tanggal);
    dest.writeString(jenisTransaksi);
    dest.writeInt(myImage);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  public static final Creator<Transaksi> CREATOR = new Creator<Transaksi>() {
    @Override
    public Transaksi createFromParcel(Parcel in) {
      return new Transaksi(in);
    }

    @Override
    public Transaksi[] newArray(int size) {
      return new Transaksi[size];
    }
  };
}
