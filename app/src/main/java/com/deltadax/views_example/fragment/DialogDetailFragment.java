package com.deltadax.views_example.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.deltadax.views_example.R;
import com.deltadax.views_example.entity.ListItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link DialogDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DialogDetailFragment extends DialogFragment {
    private static final String TAG = "DetailFragment";

    private static final String ARG_PARAM1 = "param1";
    @BindView(R.id.imagen)
    ImageView imagen;
    @BindView(R.id.nombre)
    TextView nombre;
    @BindView(R.id.puntos)
    TextView puntos;
    Unbinder unbinder;

    private ListItem item;

    public DialogDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param item Parameter 1.
     * @return A new instance of fragment DetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DialogDetailFragment newInstance(ListItem item) {
        DialogDetailFragment fragment = new DialogDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM1, item);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            item = getArguments().getParcelable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        unbinder = ButterKnife.bind(this, rootView);

        Log.d(TAG, "onCreateView: En el fragment");

        if (item != null) {
            Glide.with(this)
                    .load(item.getImage())
                    .thumbnail(0.1f)
                    .apply(RequestOptions.centerInsideTransform())
                    .into(imagen);

            nombre.setText(item.getName());
            puntos.setText(String.valueOf(item.getPoints()));
        }

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        int width = 800;
        int height = 900;
        if (getDialog() != null) {
            if (getDialog().getWindow() != null) {
                getDialog().getWindow().setLayout(width, height);
            }
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
