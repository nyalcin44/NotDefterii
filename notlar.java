package com.neslihan.notuygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.neslihan.notuygulamasi.model.Not;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class notlar extends AppCompatActivity {

    public static void add(Not not) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notlar);

        Calendar c = Calendar.getInstance();
        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss aa");
        String datetime = dateformat.format(c.getTime());
        System.out.println(datetime);
    }
}