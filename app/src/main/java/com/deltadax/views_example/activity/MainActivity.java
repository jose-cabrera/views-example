package com.deltadax.views_example.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.deltadax.views_example.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Activity donde implementaremos Linear layout para crear un formulario sencillo
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @BindView(R.id.tag_nombre)
    TextView tagNombre;
    @BindView(R.id.et_nombre)
    EditText etNombre;
    @BindView(R.id.layout_nombre)
    LinearLayout layoutNombre;
    @BindView(R.id.tag_edad)
    TextView tagEdad;
    @BindView(R.id.et_edad)
    EditText etEdad;
    @BindView(R.id.layout_edad)
    LinearLayout layoutEdad;
    @BindView(R.id.tag_correo)
    TextView tagCorreo;
    @BindView(R.id.et_correo)
    EditText etCorreo;
    @BindView(R.id.layout_correo)
    LinearLayout layoutCorreo;
    @BindView(R.id.tag_telefono)
    TextView tagTelefono;
    @BindView(R.id.et_telefono)
    EditText etTelefono;
    @BindView(R.id.layout_telefono)
    LinearLayout layoutTelefono;
    @BindView(R.id.tag_contrasenia)
    TextView tagContrasenia;
    @BindView(R.id.et_contrasenia)
    EditText etContrasenia;
    @BindView(R.id.layout_contrasenia)
    LinearLayout layoutContrasenia;
    @BindView(R.id.button)
    AppCompatButton button;
    @BindView(R.id.resultado)
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);

        //TODO: Ejemplo seteando una vista inflada al activity
        ScrollView view = (ScrollView) getLayoutInflater().inflate(R.layout.activity_main, null);


        AppCompatButton button = new AppCompatButton(this);
        button.setText("Hola MOY!");
        button.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etNombre.setError("YA VAMONOS");
            }
        });
        ((LinearLayout) view.getChildAt(0)).addView(button);

        setContentView(view);
        ButterKnife.bind(this);

        AppCompatButton button2 = new AppCompatButton(this);
        button2.setText("HOLA PTAY");
        button2.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));

        layoutNombre.addView(button2);

        etNombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }


    @OnClick(R.id.button)
    public void onViewClicked() {
        Log.d(TAG, "onViewClicked: Hola");

        pintarListaDeIngresos(obtenerListaDeIngresos());
    }

    public String obtenerListaDeIngresos() {

        String listado = "%s\n%s\n%s\n%s\n%s";

        etNombre.setError(null);

        String resultado = String.format(listado,
                etNombre.getText().toString(),
                etEdad.getText().toString(),
                etCorreo.getText().toString(),
                etTelefono.getText().toString(),
                etContrasenia.getText().toString()
        );

        Log.d(TAG, "obtenerListaDeIngresos: "+resultado);
        return resultado;

    }

    public void pintarListaDeIngresos(String listado) {

        resultado.setText(listado);

    }
}
