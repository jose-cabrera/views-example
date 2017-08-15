package com.deltadax.views_example.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.deltadax.views_example.R;
import com.deltadax.views_example.ViewsApps;
import com.deltadax.views_example.adapter.HorizontalListAdapter;
import com.deltadax.views_example.adapter.VerticalListAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleListActivity extends AppCompatActivity implements HorizontalListAdapter.horizontalListInterface {

    @BindView(R.id.recylcer)
    RecyclerView recylcer;

    VerticalListAdapter adapter;
    HorizontalListAdapter hAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_list);
        ButterKnife.bind(this);

        adapter = new VerticalListAdapter(this);
        hAdapter = new HorizontalListAdapter(this, this);

//        recylcer.setLayoutManager(
//                new LinearLayoutManager(
//                        this,
//                        LinearLayoutManager.HORIZONTAL,
//                        false));
        recylcer.setLayoutManager(
                new GridLayoutManager(
                        this, 4
                ));
//        recylcer.setLayoutManager(
//                new LinearLayoutManager(
//                        this,
//                        LinearLayoutManager.VERTICAL,
//                        false));

//        recylcer.setAdapter(adapter);
        recylcer.setAdapter(hAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.setLista(ViewsApps.getItems());
        hAdapter.setLista(ViewsApps.getItems());
    }

    @Override
    public void onClickItem(int position) {
        DetalleActivity.start(this, hAdapter.getLista().get(position));
    }
}
