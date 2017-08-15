package com.deltadax.views_example.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.deltadax.views_example.R;
import com.deltadax.views_example.entity.ListItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by JosePablo on 01/08/17.
 * Adapter para controlar la lista vertical
 */

public class VerticalListAdapter extends RecyclerView.Adapter<VerticalListAdapter.VerticalItemViewHolder> {

    private ArrayList<ListItem> lista;
    private Context context;

    public VerticalListAdapter(Context context) {
        this.context = context;
    }

    public void setLista(ArrayList<ListItem> lista) {
        this.lista = lista;
        this.notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (lista.get(position).getPoints() > 50) {
            return 1;
        } else {
            return 2;
        }
    }

    @Override
    public VerticalItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 1: //Vertical
                View v = LayoutInflater.from(context).inflate(R.layout.vertical_item, parent, false);
                return new VerticalItemViewHolder(v);

            case 2://Horizontal //TODO
                View v2 = LayoutInflater.from(context).inflate(R.layout.vertical_item, parent, false);
                return new VerticalItemViewHolder(v2);

            default:
                View v3 = LayoutInflater.from(context).inflate(R.layout.vertical_item, parent, false);
                return new VerticalItemViewHolder(v3);
        }
    }

    @Override
    public void onBindViewHolder(VerticalItemViewHolder holder, int position) {

        if (lista != null) {
            holder.itemNombre.setText(lista.get(position).getName());
            holder.itemPuntos.setText(String.valueOf(lista.get(position).getPoints()));

            Glide.with(context)
                    .load(lista.get(position).getImage())
                    .thumbnail(0.1f)
                    .apply(RequestOptions.centerCropTransform())
                    .into(holder.imagen);
        }

    }

    @Override
    public int getItemCount() {
        return lista == null ? 0 : lista.size();
    }

    class VerticalItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_nombre)
        TextView itemNombre;
        @BindView(R.id.item_puntos)
        TextView itemPuntos;
        @BindView(R.id.imagen)
        ImageView imagen;

        public VerticalItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
