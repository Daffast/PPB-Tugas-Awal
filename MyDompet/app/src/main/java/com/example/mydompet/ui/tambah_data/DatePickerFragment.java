package com.example.mydompet.ui.tambah_data;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

  private OnDateSetListener callbackListener;


  public interface OnDateSetListener {
    void onDateSet(DatePicker view, int year, int month, int day);
  }

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);

    try {
      callbackListener = (OnDateSetListener) context;
    } catch (ClassCastException e) {
      throw new ClassCastException(context.toString() + " must implement OnDateListener");
    }
  }

  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    // Use the current date as the default date in the picker
    final Calendar c = Calendar.getInstance();
    int year = c.get(Calendar.YEAR);
    int month = c.get(Calendar.MONTH);
    int day = c.get(Calendar.DAY_OF_MONTH);

    // Create a new instance of DatePickerDialog and return it
    return new DatePickerDialog(getContext(), this, year, month, day);
  }

  public void onDateSet(DatePicker view, int year, int month, int day) {
    if (callbackListener != null) {
      callbackListener.onDateSet(view, year, month, day);
    }
  }
}
