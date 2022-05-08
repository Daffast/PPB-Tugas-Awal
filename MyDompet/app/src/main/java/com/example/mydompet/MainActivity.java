package com.example.mydompet;

import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;

import com.example.mydompet.ui.tambah_data.DatePickerFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements DatePickerFragment.OnDateSetListener {

  private Locale locale;
  private Button dateButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
    getSupportActionBar().hide(); //hide the title bar
    setContentView(R.layout.activity_main);
    BottomNavigationView navView = findViewById(R.id.nav_view);
    // Passing each menu ID as a set of Ids because each
    // menu should be considered as top level destinations.
    AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
            R.id.navigation_home, R.id.navigation_tambah_data)
            .build();
    NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
    NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
    NavigationUI.setupWithNavController(navView, navController);

    dateButton = findViewById(R.id.buttonDatePicker);

    locale = getResources().getConfiguration().locale;
    locale.setDefault(locale);
  }

  @Override
  public void onDateSet(DatePicker view, int year, int month, int day) {
    final Calendar calendar = Calendar.getInstance(locale);
    final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);

    calendar.set(year, month, day);
    SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy");
    String dateString = format.format(calendar.getTime());
    dateButton = findViewById(R.id.buttonDatePicker);
    dateButton.setText(dateString);

  }
}