package com.coursera.gvalerio.tareasemana2;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class EditarActivity extends AppCompatActivity {

    Button btnSiguiente;
    TextInputEditText tiNombrecompleto;
    DatePicker dpFecha;
    TextInputEditText tITelefono;
    TextInputEditText tIEmail;
    TextInputEditText tIDescripcionContacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);


        incializarControles();
        obtenerParametros();

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(EditarActivity.this, ConfirmardatosActivity.class);
                intent.putExtra(getString(R.string.pNombre_completo), tiNombrecompleto.getText().toString());

                int year = dpFecha.getYear();
                int month = dpFecha.getMonth();
                int day = dpFecha.getDayOfMonth();

                intent.putExtra(getString(R.string.pFecha_nacimientoYear), year);
                intent.putExtra(getString(R.string.pFecha_nacimientoMonth), month);
                intent.putExtra(getString(R.string.pFecha_nacimientoDay), day);
                intent.putExtra(getString(R.string.pTelefono), tITelefono.getText().toString());
                intent.putExtra(getString(R.string.pEmail), tIEmail.getText().toString());
                intent.putExtra(getString(R.string.pDescripcion_contacto), tIDescripcionContacto.getText().toString());

                startActivity(intent);
            }
        });
    }

    private void incializarControles(){
        tiNombrecompleto = (TextInputEditText)findViewById(R.id.tINombreCompleto);
        dpFecha = (DatePicker)findViewById(R.id.dpFecha);

        tITelefono = (TextInputEditText)findViewById(R.id.tITelefono);
        tIEmail = (TextInputEditText)findViewById(R.id.tIEmail);
        tIDescripcionContacto = (TextInputEditText)findViewById(R.id.tIDescripcionContacto);
        btnSiguiente = (Button)findViewById(R.id.btnSiguiente);
    }

    private void obtenerParametros(){
        Bundle parametros = getIntent().getExtras();
        if(parametros != null) {
            tiNombrecompleto.setText( parametros.getString(getResources().getString(R.string.pNombre_completo)));
            dpFecha.updateDate(parametros.getInt(getResources().getString(R.string.pFecha_nacimientoYear)),  parametros.getInt(getResources().getString(R.string.pFecha_nacimientoMonth)), parametros.getInt(getString(R.string.pFecha_nacimientoDay)));
            tITelefono.setText(parametros.getString(getResources().getString(R.string.pTelefono)));
            tIEmail.setText(parametros.getString(getResources().getString(R.string.pEmail)));
            tIDescripcionContacto.setText(parametros.getString(getResources().getString(R.string.pDescripcion_contacto)));
        }
    }
}
