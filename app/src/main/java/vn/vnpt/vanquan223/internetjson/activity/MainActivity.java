package vn.vnpt.vanquan223.internetjson.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import vn.vnpt.vanquan223.internetjson.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button listview;
    Button recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = findViewById(R.id.listview);
        recyclerview = findViewById(R.id.recyclerview);

        listview.setOnClickListener(this);
        recyclerview.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.listview){
            Intent intent = new Intent(this, ListNewsActivity.class);
            startActivity(intent);
        }else if (v.getId() == R.id.recyclerview){
            Intent intent = new Intent(this, RecyclerViewActivity.class);
            startActivity(intent);
        }
    }
}
