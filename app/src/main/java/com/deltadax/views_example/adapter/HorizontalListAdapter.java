package com.deltadax.views_example.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.deltadax.views_example.R;
import com.deltadax.views_example.activity.DetalleActivity;
import com.deltadax.views_example.entity.ListItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by JosePablo on 09/08/17.
 * WE
 */

public class HorizontalListAdapter extends RecyclerView.Adapter<HorizontalListAdapter.HorizantalItemViewHolder> {

    private Context context;
    private horizontalListInterface listener;
    private ArrayList<ListItem> lista;

    public HorizontalListAdapter(Context context, horizontalListInterface listener) {
        this.context = context;
        this.listener = listener;
    }

    public void setLista(ArrayList<ListItem> lista) {
        this.lista = lista;
    }

    public ArrayList<ListItem> getLista() {
        return lista;
    }

    @Override
    public HorizantalItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v3 = LayoutInflater.from(context).inflate(R.layout.horizontal_item, parent, false);
        return new HorizantalItemViewHolder(v3);
    }

    @Override
    public void onBindViewHolder(final HorizantalItemViewHolder holder, int position) {

        if (lista != null) {
            holder.nombre.setText(lista.get(position).getName());
            holder.punteo.setText(String.valueOf(lista.get(position).getPoints()));

            Glide.with(context)
                    .load(lista.get(position).getImage())
                    .thumbnail(0.1f)
                    .apply(RequestOptions.centerCropTransform())
                    .into(holder.imagen);

            holder.container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClickItem(holder.getAdapterPosition());
                }
            });
        }

    }


    @Override
    public int getItemCount() {
        return lista == null ? 0 : lista.size();
    }

    class HorizantalItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imagen)
        ImageView imagen;
        @BindView(R.id.nombre)
        TextView nombre;
        @BindView(R.id.punteo)
        TextView punteo;
        @BindView(R.id.container)
        LinearLayout container;

        public HorizantalItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface horizontalListInterface {
        void onClickItem(int position);
    }

}
