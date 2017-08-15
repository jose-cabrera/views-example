package com.deltadax.views_example.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;

import com.deltadax.views_example.R;
import com.deltadax.views_example.ViewsApps;
import com.deltadax.views_example.adapter.HorizontalListAdapter;
import com.deltadax.views_example.adapter.VerticalListAdapter;
import com.deltadax.views_example.entity.ListItem;
import com.deltadax.views_example.fragment.DetailFragment;
import com.deltadax.views_example.fragment.DialogDetailFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleListActivity extends AppCompatActivity implements HorizontalListAdapter.horizontalListInterface {

    @BindView(R.id.recylcer)
    RecyclerView recylcer;

    VerticalListAdapter adapter;
    HorizontalListAdapter hAdapter;
    @BindView(R.id.frame)
    FrameLayout frame;

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
//        cambiarVisibilidad(false);
//        llamarFragmetn(hAdapter.getLista().get(position));
        abrirDialog(hAdapter.getLista().get(position));
    }

    private void abrirDialog(ListItem item) {
        DialogDetailFragment dialog = DialogDetailFragment.newInstance(item);
        dialog.show(getSupportFragmentManager(), DialogDetailFragment.class.getSimpleName());

    }

    private void llamarFragmetn(ListItem item) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frame, DetailFragment.newInstance(item))
                .addToBackStack(DetailFragment.class.getSimpleName())
                .commit();
    }

    private void cambiarVisibilidad(boolean bandera) {
        recylcer.setVisibility(bandera ? View.VISIBLE : View.GONE);
        frame.setVisibility(bandera ? View.GONE : View.VISIBLE);
    }

    @Override
    public void onBackPressed() {

        int count = getSupportFragmentManager()
                .getBackStackEntryCount();

        super.onBackPressed();

        if (count != 0) {
//            cambiarVisibilidad(true);
            DialogDetailFragment dialogo = (DialogDetailFragment) getSupportFragmentManager().getFragments().get(0);
            dialogo.dismiss();
        }

    }
}
