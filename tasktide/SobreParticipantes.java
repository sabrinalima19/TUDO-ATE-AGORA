package com.example.tasktide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tasktide.DAO.DAO;
import com.example.tasktide.Objetos.Participantes;


public class SobreParticipantes extends AppCompatActivity {

    private CheckBox chbDiscentesEM, chbDiscentesES, chbDocentes, chbServidoresGeral;
    private Button btnVoltarParaTelaCriarEvento, btnIrParaTelaOutrasInformacoes;
    private Spinner spnQuantParticipantes;
    private long idEvento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre_participantes);

        chbDiscentesEM = findViewById(R.id.chbDiscentesEM);
        chbDiscentesES = findViewById(R.id.chbDiscentesES);
        chbDocentes = findViewById(R.id.chbDocentes);
        chbServidoresGeral = findViewById(R.id.chbServidoresGeral);
        btnVoltarParaTelaCriarEvento = findViewById(R.id.btnVoltarParaTelaCriarEvento);
        btnIrParaTelaOutrasInformacoes = findViewById(R.id.btnIrParaTelaOutrasInformacoes);
        spnQuantParticipantes = findViewById(R.id.spnQuantParticipantes);


        idEvento = getIntent().getLongExtra("ID_EVENTO", -1);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.QuantidadePessoas, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnQuantParticipantes.setAdapter(adapter);

        btnIrParaTelaOutrasInformacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isAnyCheckBoxChecked()) {
                    Toast.makeText(SobreParticipantes.this, "Selecione pelo menos um participante.", Toast.LENGTH_SHORT).show();
                } else {
                    salvarParticipantes();
                    Intent intent = new Intent(SobreParticipantes.this, QuaseLa.class);
                    intent.putExtra("ID_EVENTO", idEvento);
                    startActivity(intent);
                }
            }
        });

        btnVoltarParaTelaCriarEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SobreParticipantes.this, OutrasInformacoess.class));
            }
        });
    }

    private boolean isAnyCheckBoxChecked() {
        return chbDiscentesEM.isChecked() || chbDiscentesES.isChecked() || chbDocentes.isChecked() || chbServidoresGeral.isChecked();
    }

    private void salvarParticipantes() {
        String quantParticipantes = spnQuantParticipantes.getSelectedItem().toString();
        DAO dao = new DAO(this);
        Participantes participantes = new Participantes(quantParticipantes);
        dao.inserirParticipantes(participantes, idEvento);
    }
}
