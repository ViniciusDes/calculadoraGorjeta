package vinicius.desenvolvimento.com.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editValor;
    private TextView textoPorcentagem;
    private TextView textoGorjeta;
    private TextView textoTotal;
    private SeekBar seekBarPorct;

    private double porcentagem = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

          textoPorcentagem = findViewById(R.id.textPorcentagem);
          seekBarPorct     = findViewById(R.id.seekBarPorcentagem);
          editValor        = findViewById(R.id.editValor);
          textoGorjeta     = findViewById(R.id.textGorjeta);
          textoTotal       = findViewById(R.id.textTotal);

          seekBarPorct.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem = progress;  //math - classe round arrendendamento
                textoPorcentagem.setText(Math.round(porcentagem) + "%");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    public void calcular(){
        String valorR = editValor.getText().toString();
        //double valor = valor
        if(valorR == null || valorR.equals("")){
            Toast.makeText(
                    getApplicationContext(),
                    "Infome um valor para calcular",
                    Toast.LENGTH_SHORT
            ).show();
        }else{
            double valorInformado = Double.parseDouble(valorR);
            //apenas obtem o valor em string
            double valorGorjeta = valorInformado * (porcentagem/100);
            double valorTotal   = valorGorjeta + valorInformado;
            textoGorjeta.setText("R$: " + Math.round(valorGorjeta));
            textoTotal.setText("R$: " + Math.round(valorTotal));
        }
    }

}
