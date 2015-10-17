package com.rongyu.wwt.advancedCompent;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.rongyu.wwt.androiddemos.R;

public class AutoCompleteTextViewActivity extends AppCompatActivity {

    private String[] books = new String[] {
            "rollen",
            "rollenholt",
            "rollenren",
            "roll"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_text_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //创建ArrayAdapter创建数组
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,books);
        AutoCompleteTextView autoCompleteTV = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        autoCompleteTV.setAdapter(adapter);

    }

}
