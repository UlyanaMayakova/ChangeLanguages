package com.example.changelanguages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner spinner = findViewById(R.id.spinner);
        final TextView text = findViewById(R.id.text);
        Button ok = findViewById(R.id.button);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this, R.array.languages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String language = spinner.getSelectedItem().toString();
                Locale locale = new Locale("ru");

                switch (language) {
                    case "Русский":
                        locale = new Locale("ru");
                        break;
                    case "English":
                        locale = new Locale("en");
                        break;
                }
                Configuration configuration = new Configuration();
                configuration.setLocale(locale);
                getResources().updateConfiguration(configuration, getBaseContext().
                        getResources().getDisplayMetrics());
                text.setText(R.string.text);
                recreate();
            }
        });
    }
}