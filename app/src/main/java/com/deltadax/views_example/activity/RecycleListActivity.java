package com.deltadax.views_example.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.deltadax.views_example.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleListActivity extends AppCompatActivity {

    @BindView(R.id.recylcer)
    RecyclerView recylcer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_list);
        ButterKnife.bind(this);
    }


}
