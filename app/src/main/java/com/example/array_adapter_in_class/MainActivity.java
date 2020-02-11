package com.example.array_adapter_in_class;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listV;
    private String[] array = {"sunday","monday","Tuesday","Wednesday","Thursday","Friday","saturday",
            "sunday","monday","Tuesday","Wednesday","Thursday","Friday","saturday",
            "sunday","monday","Tuesday","Wednesday","Thursday","Friday","saturday"};
    private String [] weather = {"sunny","overcast","humid","cloudy","sunny","overcast","humid","cloudy","sunny","overcast","humid","cloudy","sunny"
            ,"overcast","humid","cloudy","sunny","overcast","humid","cloudy","sunny"};
    private ArrayAdapter<String> ouradap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //    connect();
        customized_list_view();

    }
    private void connect()
    {
        try{
            listV = findViewById(R.id.LV);
            ouradap = new ArrayAdapter<String>(
                    this,
                    android.R.layout.simple_list_item_1,
                    array
            );
            listV.setAdapter(ouradap);
            listV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(MainActivity.this,
                            "Position Clicked"+position,Toast.LENGTH_LONG).show();
                }
            });



        }catch (Exception e)
        {
            Toast.makeText(this,"Error is in connect "+e.getMessage(),Toast.LENGTH_LONG);
        }
        listV = findViewById(R.id.LV);
    }

    private  void customized_list_view()
    {
        try {

            listV = findViewById(R.id.LV);
            ouradap = new ArrayAdapter<>(
                    this,
                    R.layout.my_row,
                    R.id.row_TV,
                    weather
            );

            listV.setAdapter(ouradap);
            listV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    TextView temp= view.findViewById(R.id.row_TV);
                    Toast.makeText(MainActivity.this,
                           "Text Is :"+temp.getText().toString()+" and position is "+position,Toast.LENGTH_LONG ).show();
                    Intent myintent = new Intent(getBaseContext(),Second.class);
                    myintent.putExtra("mes","You Came From Clicking on "+temp.getText().toString());
                    startActivity(myintent);
                }
            });

        }catch (Exception e)
        {
            Toast.makeText(this,"Error in customized view" +e.getMessage(),Toast.LENGTH_SHORT).show();
        }

    }

}
