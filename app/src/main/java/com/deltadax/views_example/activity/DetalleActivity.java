package com.deltadax.views_example.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.deltadax.views_example.R;
import com.deltadax.views_example.entity.ListItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetalleActivity extends AppCompatActivity {

    private static final String ARG_ITEM = "detalle";
    @BindView(R.id.imagen)
    ImageView imagen;
    @BindView(R.id.nombre)
    TextView nombre;
    @BindView(R.id.puntos)
    TextView puntos;
    private ListItem item;

    public static void start(Context context, ListItem item) {
        Intent starter = new Intent(context, DetalleActivity.class);
        starter.putExtra(ARG_ITEM, item);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        ButterKnife.bind(this);

        if (savedInstanceState != null) {
            item = savedInstanceState.getParcelable(ARG_ITEM);
        } else {
            item = getIntent().getExtras().getParcelable(ARG_ITEM);
        }


        if (item != null) {
            Glide.with(this)
                    .load(item.getImage())
                    .thumbnail(0.1f)
                    .apply(RequestOptions.centerInsideTransform())
                    .into(imagen);

            nombre.setText(item.getName());
            puntos.setText(String.valueOf(item.getPoints()));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(ARG_ITEM, item);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        item = savedInstanceState.getParcelable(ARG_ITEM);
    }
}
