package com.example.tes20april;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Calendar;

public class PasienOverview extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    GraphView suhu;
    GraphView tekananDarah;
    GraphView detakJantung;
    GraphView lajuPernapasan;
    ImageButton btnGoBack;
    Button btnStartDate;
    Button btnEndDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasien_overview);

        suhu = findViewById(R.id.graphicSuhu);
        tekananDarah = findViewById(R.id.graphicTekananDarah);
        detakJantung = findViewById(R.id.graphicDetakJantung);
        lajuPernapasan = findViewById(R.id.graphicLajuPernapasan);

        LineGraphSeries<DataPoint> dataSuhu = new LineGraphSeries<>(new DataPoint[]{
           new DataPoint(0,1),
           new DataPoint(1,2),
           new DataPoint(1,5),
           new DataPoint(1,3),
           new DataPoint(3,2)
        });

        LineGraphSeries<DataPoint> dataTekananDarah = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0,1),
                new DataPoint(1,2),
                new DataPoint(1,5),
                new DataPoint(1,3),
                new DataPoint(3,2)
        });

        LineGraphSeries<DataPoint> dataDetakJantung = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0,1),
                new DataPoint(1,2),
                new DataPoint(1,5),
                new DataPoint(1,3),
                new DataPoint(3,2)
        });

        LineGraphSeries<DataPoint> dataLajuPernapasan = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0,1),
                new DataPoint(1,2),
                new DataPoint(1,5),
                new DataPoint(1,3),
                new DataPoint(3,2)
        });

        suhu.addSeries(dataSuhu);
        tekananDarah.addSeries(dataTekananDarah);
        detakJantung.addSeries(dataDetakJantung);
        lajuPernapasan.addSeries(dataLajuPernapasan);

        suhu.setTitle("Suhu Tubuh");
        tekananDarah.setTitle("Tekanan Darah");
        detakJantung.setTitle("Detak Jantung");
        lajuPernapasan.setTitle("Laju Pernapasan");




        btnGoBack = findViewById(R.id.goBack);
        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnStartDate = findViewById(R.id.btnStartDate);
        btnEndDate = findViewById(R.id.btnEndDate);

        Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);
        final DatePickerDialog start = new DatePickerDialog(getApplicationContext(), PasienOverview.this, mYear, mMonth, mDay);
        DatePickerDialog end = new DatePickerDialog(getApplicationContext(), PasienOverview.this, mYear, mMonth, mDay);

        btnStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start.show();
                String startDate = start.getDatePicker().getYear()+"-"+start.getDatePicker().getMonth()+"-"+start.getDatePicker().getDayOfMonth();
                btnStartDate.setText(startDate);
            }
        });

        btnEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void goDetail(View view) {

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

    }
}
