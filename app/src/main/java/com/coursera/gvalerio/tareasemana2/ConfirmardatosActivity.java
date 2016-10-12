package com.coursera.gvalerio.tareasemana2;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ConfirmardatosActivity extends AppCompatActivity {

    TextView tvNombreCompleto;
    TextView tvFechaNacimiento;
    TextView tvTelefono;
    TextView tvEmail;
    TextView tvDescripcion;
    Button btnConfirmarDatos;
    int intDia, intMes, intAño;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmardatos);

        inicializarControles();
        obtenerParametros();

        btnConfirmarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConfirmardatosActivity.this, EditarActivity.class);
                intent.putExtra(getResources().getString(R.string.pNombre_completo), tvNombreCompleto.getText().toString());

                intent.putExtra(getString(R.string.pFecha_nacimientoYear), intAño);
                intent.putExtra(getString(R.string.pFecha_nacimientoMonth), intMes);
                intent.putExtra(getString(R.string.pFecha_nacimientoDay), intDia);

                intent.putExtra(getString(R.string.pTelefono), tvTelefono.getText().toString());
                intent.putExtra(getString(R.string.pEmail), tvEmail.getText().toString());
                intent.putExtra(getString(R.string.pDescripcion_contacto), tvDescripcion.getText().toString());

                startActivity(intent);
            }
        });
    }

    private void inicializarControles(){
        tvNombreCompleto = (TextView)findViewById(R.id.tvNombreCompleto);
        tvFechaNacimiento = (TextView)findViewById(R.id.tvFechaNacimiento);
        tvTelefono = (TextView)findViewById(R.id.tvTelefono);
        tvEmail = (TextView)findViewById(R.id.tvEmail);
        tvDescripcion = (TextView)findViewById(R.id.tvDescripcion);
        btnConfirmarDatos = (Button)findViewById(R.id.btnConfirmarDatos);
    }

    private void obtenerParametros(){

        Bundle parametros = getIntent().getExtras();
        tvNombreCompleto.setText(parametros.getString(getString(R.string.pNombre_completo)));

        intAño = parametros.getInt(getString(R.string.pFecha_nacimientoYear));
        intDia = parametros.getInt(getString(R.string.pFecha_nacimientoDay));
        intMes = parametros.getInt(getString(R.string.pFecha_nacimientoMonth));

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, intAño);
        cal.set(Calendar.DAY_OF_MONTH, intDia);
        cal.set(Calendar.MONTH, intMes);
        String format = new SimpleDateFormat("E, MMM d, yyyy").format(cal.getTime());

        tvFechaNacimiento.setText(format);

        tvTelefono.setText(parametros.getString(getString(R.string.pTelefono)));
        tvEmail.setText(parametros.getString(getString(R.string.pEmail)));
        tvDescripcion.setText(parametros.getString(getString(R.string.pDescripcion_contacto)));
    }
}
