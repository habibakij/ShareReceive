package com.example.shareapprcv;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.example.shareapprcv.Model.Adapter.AdapterView;
import com.example.shareapprcv.Model.DataModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AdapterView adapterView;
    RecyclerView recyclerView;
    List<DataModel> list;
    private DataModel dataModel;
    private static final Uri URI= Uri.parse("content://shareapp/content_provider_table");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView= findViewById(R.id.recylerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        list= new ArrayList<DataModel>();

        Cursor cursor= getContentResolver().query(URI, null,
                null, null, null);
        String data="";

        if (cursor == null){
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        } else {
            cursor.moveToFirst();
            do {
                String email = cursor.getString(cursor.getColumnIndex("email"));
                String time = cursor.getString(cursor.getColumnIndex("currentTime"));
                //data = email + "\n" + time;
                dataModel= new DataModel(email, time);
                list.add(dataModel);
            } while (cursor.moveToNext());
            adapterView= new AdapterView(this, list);
            recyclerView.setAdapter(adapterView);
        }
    }
}
