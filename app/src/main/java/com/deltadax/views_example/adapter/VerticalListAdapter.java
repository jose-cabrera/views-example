package com.deltadax.views_example.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by JosePablo on 01/08/17.
 * Adapter para controlar la lista vertical
 */

public class VerticalListAdapter extends RecyclerView.Adapter<VerticalListAdapter.VerticalItemViewHolder> {


    @Override
    public VerticalItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(VerticalItemViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class VerticalItemViewHolder extends RecyclerView.ViewHolder {

        public VerticalItemViewHolder(View itemView) {
            super(itemView);
        }
    }
}
