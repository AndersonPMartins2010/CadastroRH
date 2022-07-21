package com.caxetasystem.cadastrorh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.security.AppUriAuthenticationPolicy;
import android.text.InputFilter;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.caxetasystem.cadastrorh.util.Mask;
import com.caxetasystem.cadastrorh.util.ValidaCPF;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText tiUf, tiCelular, tiFixo, tiCep, tiCpf, tiNascimento, tiNome,
    tiEndereco, tiNumero, tiCargo, tiLocalTrab, tiCidade, tiBairro;
    private Button btCadastro;
    private Spinner campoSexo, campoSituacaoCivil, campoEstados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCadastro = findViewById(R.id.btCadastro);

        //tiUf         = findViewById(R.id.tiUf);
        tiCelular    = findViewById(R.id.tiCelular);
        tiFixo       = findViewById(R.id.tiFixo);
        tiCep        = findViewById(R.id.tiCep);
        tiCpf        = findViewById(R.id.tiCpf);
        tiNome       = findViewById(R.id.tiNome);
        tiNascimento = findViewById(R.id.tiNascimento);
        tiEndereco   = findViewById(R.id.tiEndereco);
        tiNumero     = findViewById(R.id.tiNumero);
        tiCargo      = findViewById(R.id.tiCargo);
        tiLocalTrab  = findViewById(R.id.tiLocalTrab);
        tiBairro     = findViewById(R.id.tiBairro);
        tiCidade     = findViewById(R.id.tiCidade);

        campoSexo          = findViewById(R.id.spSexo);
        campoSituacaoCivil = findViewById(R.id.spSituacaoCivil);
        campoEstados       = findViewById(R.id.spUf);

        //Força letras maiusculas
        //tiUf.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        tiCelular.addTextChangedListener(Mask.insert("(##)#####-####",tiCelular));
        tiFixo.addTextChangedListener(Mask.insert("(##)####-####",tiFixo));
        tiCep.addTextChangedListener(Mask.insert("#####-###",tiCep));
        tiNascimento.addTextChangedListener(Mask.insert("##/##/####",tiNascimento));

        carregarSpinner();

        btCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             String verificaCpf = tiCpf.getText().toString();
             String nome = tiNome.getText().toString();
             String data = tiNascimento.getText().toString();
             String endereco = tiEndereco.getText().toString();
             String numero = tiNumero.getText().toString();
             String cargo  = tiCargo.getText().toString();
             String localTrab = tiLocalTrab.getText().toString();
             String cidade = tiCidade.getText().toString();
             String bairro = tiBairro.getText().toString();
             String sexo = campoSexo.getSelectedItem().toString();
             String sexoVerifica = "SEXO";
             String estadoCivil = campoSituacaoCivil.getSelectedItem().toString();
             String estadoCivilVerifica = "ESTADO CIVIL";
             String uf = campoEstados.getSelectedItem().toString();
             String ufVerifica = "UF";
             String celular = tiCelular.getText().toString();

             if (!nome.equals("")&& !nome.isEmpty() && nome.length()> 15){

                 if (!verificaCpf.isEmpty()){

                  if (ValidaCPF.isCPF(verificaCpf) == true){

                      if (!data.equals("") && data.length() == 10){

                          if(!sexo.equals(sexoVerifica)){

                              if(!estadoCivil.equals(estadoCivilVerifica)){

                                  if (!endereco.equals("")){
                                      if(!numero.equals("")){
                                          if (!bairro.equals("") && bairro.length()>5){
                                              if(!cidade.equals("") && cidade.length() > 8){
                                                  if(!uf.equals(ufVerifica)){
                                                      if (!celular.equals("") && celular.length() == 14){
                                                          if (!cargo.equals("") && cargo.length()> 10){
                                                              if (!localTrab.equals("") && localTrab.length()> 10){

                                                                  Toast.makeText(getApplicationContext(),"Cadastro realizado com sucesso.",
                                                                          Toast.LENGTH_SHORT).show();
                                                              }else {
                                                                  Toast.makeText(getApplicationContext(),"Informe um local de trabalho válido",
                                                                          Toast.LENGTH_SHORT).show();
                                                                  tiLocalTrab.requestFocus();
                                                              }

                                                          }else {
                                                              Toast.makeText(getApplicationContext(),"Informe um cargo válido",
                                                                      Toast.LENGTH_SHORT).show();
                                                              tiCargo.requestFocus();
                                                          }

                                                      }else{
                                                          Toast.makeText(getApplicationContext(),"Informe uma número de celuar válido",
                                                                  Toast.LENGTH_SHORT).show();
                                                          tiCelular.requestFocus();
                                                      }


                                                  }else{
                                                      Toast.makeText(getApplicationContext(),"Selecione um Estado",
                                                              Toast.LENGTH_SHORT).show();
                                                      campoEstados.requestFocus();
                                                  }

                                              }else {
                                                  Toast.makeText(getApplicationContext(),"Informe uma cidade válida",
                                                          Toast.LENGTH_SHORT).show();
                                                  tiCidade.requestFocus();
                                              }

                                          }else{
                                              Toast.makeText(getApplicationContext(),"Informe um bairro válido",
                                                      Toast.LENGTH_SHORT).show();
                                              tiBairro.requestFocus();
                                          }


                                      }else{
                                          Toast.makeText(getApplicationContext(),"Campo Número não informado",
                                                  Toast.LENGTH_SHORT).show();
                                          tiNumero.requestFocus();
                                      }

                                  }else{
                                      Toast.makeText(getApplicationContext(),"Endereço não informado",
                                              Toast.LENGTH_SHORT).show();
                                      tiEndereco.requestFocus();
                                  }
                              }else {
                                  Toast.makeText(getApplicationContext(),"Informe o Estado Civil",
                                          Toast.LENGTH_SHORT).show();
                              }



                          }else{
                              Toast.makeText(getApplicationContext(),"Informe o sexo",
                                      Toast.LENGTH_SHORT).show();
                              campoSexo.requestFocus();
                          }



                      }else {

                          Toast.makeText(getApplicationContext(),"Data válida: ex. 20101974",
                                  Toast.LENGTH_SHORT).show();
                          tiNascimento.requestFocus();
                      }


                  }else{

                         if (verificaCpf.length()!= 11){
                             Toast.makeText(getApplicationContext(), "CPF POSSUI 11 NÚMEROS",
                                     Toast.LENGTH_SHORT).show();
                             tiCpf.requestFocus();
                         }else{
                             Toast.makeText(getApplicationContext(), "CPF INVÁLIDO",
                                     Toast.LENGTH_SHORT).show();
                             tiCpf.setText("");
                             tiCpf.requestFocus();
                         }


                     }

                 }else {
                     Toast.makeText(getApplicationContext(), "Informe um CPF",
                             Toast.LENGTH_SHORT).show();
                     tiCpf.requestFocus();
                 }

             }else{
                 Toast.makeText(getApplicationContext(),"Campo em branco ou nome incompleto"
                 ,Toast.LENGTH_SHORT).show();
             }

            }
        });
    }
    private void carregarSpinner(){
        String[] sexo = getResources().getStringArray(R.array.sexo);
        ArrayAdapter<String> adapterSexo = new ArrayAdapter<String>(
                //this, android.R.layout.simple_list_item_activated_1, sexo
                this, R.layout.layout_spinner, sexo
        );
        adapterSexo.setDropDownViewResource(android.R.layout.simple_list_item_activated_1);
        campoSexo.setAdapter(adapterSexo);

        String[] civil = getResources().getStringArray(R.array.civil);
        ArrayAdapter<String> adapterCivil = new ArrayAdapter<String>(
                //this, android.R.layout.simple_list_item_activated_1, civil
                this, R.layout.layout_spinner, civil
        );
        adapterCivil.setDropDownViewResource(android.R.layout.simple_list_item_activated_1);
        campoSituacaoCivil.setAdapter(adapterCivil);

        String[] estados = getResources().getStringArray(R.array.estados);
        ArrayAdapter<String> adapterEstados = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_activated_1, estados
                //this, R.layout.layout_spinner, estados
        );
        adapterEstados.setDropDownViewResource(android.R.layout.simple_list_item_activated_1);
        campoEstados.setAdapter(adapterEstados);


    }
}