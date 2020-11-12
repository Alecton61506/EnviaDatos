package ud.example.enviadatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Clases.Bebida;
import Clases.Hamburguesa;

public class MainActivity extends AppCompatActivity {
    private EditText cliente;
    private Spinner lista01, lista02, lista03;
    private CheckBox hielo;
    private Button enviab;
    private List<String> tipoh, /*tipob,*/ sino;
    private TextView mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mensaje = findViewById(R.id.textView);
        cliente = findViewById(R.id.editText);
        lista01 = findViewById(R.id.spinner);
        lista02 = findViewById(R.id.spinner2);
        lista03 = findViewById(R.id.spinner3);
        hielo = findViewById(R.id.checkBox);
        enviab=findViewById(R.id.button2);
        datosinicio();

    }

    //metodo que llena los Spinner
    private void datosinicio(){
       List<String> tipoh =new ArrayList<String>(); //este tipo de array es dinamico;
        //List<String> tipob =new ArrayList<String>();
        List<String> sino =new ArrayList<String>();
        tipoh.add("Carne");
        tipoh.add("Pollo");
        tipoh.add("Pescado");
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>
                (this,android.R.layout.simple_spinner_item, tipoh);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lista01.setAdapter(adaptador);
        sino.add("SI"); sino.add("NO");
        ArrayAdapter<String> adaptador2 =new ArrayAdapter<String>
                (this,android.R.layout.simple_spinner_item, sino);
        adaptador2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lista02.setAdapter(adaptador2);
    }
    //metodo del botton
    public void llamadaactividad (View v) {

        if (cliente.getText().toString().equals("")) {

            mensaje.setText("Por favor Ingrese su Nombre para hacer un pedido");

        } else {

            boolean cebolla = false;
            if (lista02.getSelectedItem().toString().equals("SI")) cebolla = true;
            Hamburguesa miham = new Hamburguesa(lista01.getSelectedItem().toString(), cebolla); //instancia de la clase hamburguesa


            boolean hielo = this.hielo.isChecked();
            Bebida mibeb = new Bebida(lista03.getSelectedItem().toString(), hielo); //instamcia de la clase bebida

            Intent int01 = new Intent(this, Actividad2.class);
            int01.putExtra("Cliente", cliente.getText().toString());
            int01.putExtra("Hamburguesa", miham);  //serializable
            int01.putExtra("Bebida", mibeb);  //Parcerable
            startActivity(int01);
        }
    }
}