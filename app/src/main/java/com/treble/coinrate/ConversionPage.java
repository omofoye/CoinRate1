package com.treble.coinrate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ConversionPage extends AppCompatActivity {


    private String convRate;
    private double output;
    private int input;
    private EditText inputTxt;
    private double rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_page);

        Bundle i = getIntent().getExtras();
        convRate = i.getString("convRate");
     final   String currencyPos = i.getString("currencyPos");
      final   String selectedCoin = i.getString("selectedCoin");





        if(selectedCoin.equals("Bitcoin")){

            final String[] coinType = {"Select currency",selectedCoin,currencyPos};


            ArrayAdapter<String> categoryAdapter = new ArrayAdapter<String>(ConversionPage.this,
                    android.R.layout.simple_spinner_item,coinType);

            final Spinner spinner = (Spinner) findViewById(R.id.spinner);
            // spinner2 store the selected item in spinner object


            // Drop down layout style - list view with radio button
            categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            // attaching  categoryAdapter to spinner

            spinner.setAdapter(categoryAdapter);


//            if(select.equals(selectedCoin)){
                final String[] coinTypeTwo ={"Select coin",selectedCoin,currencyPos};
                ArrayAdapter<String> categoryAdapterTwo = new ArrayAdapter<String>(ConversionPage.this,
                        android.R.layout.simple_spinner_item,coinTypeTwo);

                final Spinner spinnerTwo = (Spinner) findViewById(R.id.spinner2);
                // spinner2 store the selected item in spinner object


                // Drop down layout style - list view with radio button
                categoryAdapterTwo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                // attaching  categoryAdapter to spinner

                spinnerTwo.setAdapter(categoryAdapter);








            Button calBtn = findViewById(R.id.calculate);
            calBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    inputTxt = findViewById(R.id.input_unit);

                    final   String selectOne = spinnerTwo.getSelectedItem().toString();
                    final  String select = spinner.getSelectedItem().toString();
                    if(inputTxt.length() == 0 || select.equals("Select currency") || selectOne.equals("Select currency") ){
                        Toast.makeText(ConversionPage.this, "Please fill up the missing field(s)",Toast.LENGTH_LONG).show();
                        return;
                    }

                    if(selectOne.equals(select)){
                        Toast.makeText(ConversionPage.this,"Please select different currencies above",Toast.LENGTH_LONG).show();
                        return;
                    }

                    String in = inputTxt.getText().toString();
                    float input = Float.parseFloat(in);
                    float rate = Float.parseFloat(convRate);

                    final TextView out = findViewById(R.id.output_txt);



                    if(select.equals(selectedCoin) && selectOne.equals(currencyPos) && inputTxt.length()>0){

                       float  output =  input * rate;

                        out.setText(""+output);

                    }
                    else if(select.equals(currencyPos) && selectOne.equals(selectedCoin) && inputTxt.length()>0){

                       float output =  input / rate;
                        out.setText(""+output);
                    }

                    inputTxt.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                            out.setText("");
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });




                }
            });





        }

        else if(selectedCoin.equals("Ethereum")){

            final String[] coinType = {"Select currency",selectedCoin,currencyPos};


            ArrayAdapter<String> categoryAdapter = new ArrayAdapter<String>(ConversionPage.this,
                    android.R.layout.simple_spinner_item,coinType);

            final Spinner spinner = (Spinner) findViewById(R.id.spinner);
            // spinner2 store the selected item in spinner object


            // Drop down layout style - list view with radio button
            categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            // attaching  categoryAdapter to spinner

            spinner.setAdapter(categoryAdapter);

//            String selectTwo = spinner.getSelectedItem().toString();


            final String[] coinTypeTwo ={"Select coin",selectedCoin,currencyPos};
            ArrayAdapter<String> categoryAdapterTwo = new ArrayAdapter<String>(ConversionPage.this,
                    android.R.layout.simple_spinner_item,coinTypeTwo);

            final Spinner spinnerTwo = (Spinner) findViewById(R.id.spinner2);
            // spinner2 store the selected item in spinner object


            // Drop down layout style - list view with radio button
            categoryAdapterTwo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            // attaching  categoryAdapter to spinner

            spinnerTwo.setAdapter(categoryAdapter);

//            String selectThree = spinnerTwo.getSelectedItem().toString();




            Button calBtn = findViewById(R.id.calculate);
            calBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    inputTxt = findViewById(R.id.input_unit);

                    final   String selectThree = spinnerTwo.getSelectedItem().toString();
                    final  String selectTwo = spinner.getSelectedItem().toString();
                    if(inputTxt.length() == 0 || selectTwo.equals("Select currency") || selectThree.equals("Select currency") ){
                        Toast.makeText(ConversionPage.this, "Please fill up the missing field(s)",Toast.LENGTH_LONG).show();
                        return;
                    }

                    if(selectTwo.equals(selectThree)){
                        Toast.makeText(ConversionPage.this,"Please select different currencies above",Toast.LENGTH_LONG).show();
                        return;
                    }
                    String in = inputTxt.getText().toString();
                    float input = Float.parseFloat(in);
                    float rate = Float.parseFloat(convRate);

                    final TextView out = findViewById(R.id.output_txt);



                    if(selectTwo.equals(selectedCoin) && selectThree.equals(currencyPos) && inputTxt.length()>0){

                        float  output =  input * rate;

                        out.setText(""+output);

                    }
                    else if(selectTwo.equals(currencyPos) && selectThree.equals(selectedCoin) && inputTxt.length()>0){

                        float output =  input / rate;
                        out.setText(""+output);
                    }

                    inputTxt.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                            out.setText("");
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });





                }
            });
        }








    }
}
