package com.example.my.a06;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    // Set the length of substring "AppCompat"
    public static final int NAME_CLASS_ADD=9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar actionBarToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(actionBarToolbar);
        actionBarToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_18dp);
        actionBarToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayout.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerView.Adapter adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);
    }

    public void onControlClick(View view) {

        Toast ControlInfo = Toast.makeText(getApplicationContext(),
                view.getClass().getSimpleName().substring(MainActivity.NAME_CLASS_ADD), Toast.LENGTH_SHORT);
        ControlInfo.setGravity(Gravity.CENTER, 0, 0);
        ControlInfo.show();
    }
}
