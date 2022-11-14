package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    ListView lvCaSi;
    ArrayList<Casi> arrayCaSi;
    CaSiAdapter adapter;

    private Button btnTroVe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        AnhXa();

        adapter = new CaSiAdapter(this, R.layout.so_ca_si, arrayCaSi);
        lvCaSi.setAdapter(adapter);

        btnTroVe = (Button) findViewById(R.id.buttontve);

        btnTroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListViewActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void AnhXa(){
        lvCaSi = (ListView) findViewById(R.id.listviewCaSi);
        arrayCaSi = new ArrayList<>();

        arrayCaSi.add(new Casi("Ca sĩ Mỹ Tâm", "Mỹ Tâm","Việt Nam","5 sao", R.drawable.mytam));
        arrayCaSi.add(new Casi("Ca sĩ Chi Dân", "Chi Dân","Việt Nam","5 sao", R.drawable.chidan));
        arrayCaSi.add(new Casi("Ca sĩ Hoàng Yến", "Hoàng Yến Chibi","Việt Nam","5 sao", R.drawable.hoangyen));
        arrayCaSi.add(new Casi("Ca sĩ Sơn Tùng", "Sơn Tùng MTP","Việt Nam","5 sao", R.drawable.sontung));
        arrayCaSi.add(new Casi("Ca sĩ Vũ Cát Tường", "Vũ Cát Tường","Việt Nam","5 sao", R.drawable.vucattuong));

    }
}