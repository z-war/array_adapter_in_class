package com.example.array_adapter_in_class;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Second extends AppCompatActivity {

    private TextView mesa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mesa = findViewById(R.id.mes);
        String mymes = getIntent().getStringExtra("mes");
        mesa.setText(mymes);
    }
}
