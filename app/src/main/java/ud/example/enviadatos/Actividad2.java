package ud.example.enviadatos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

import Clases.Bebida;
import Clases.Hamburguesa;

public class Actividad2 extends AppCompatActivity {
private TextView logTexview;
private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);
        logTexview = findViewById(R.id.textView8);
        scrollView = findViewById(R.id.scroll);
        Bundle bundle = this.getIntent().getExtras();
        log( "Cliente:"+bundle.getString( "Cliente")); //get string por que el nombre es string
        log( "");
        Hamburguesa mipedHam = (Hamburguesa) bundle.get("Hamburguesa");
        Bebida mipedbeb=(Bebida) bundle.get("Bebida");
        log( "Hamburguesa");
        log( "Tipo" +mipedHam.getTipo() );
        if(mipedHam.getCebolla()) log("Con cebolla");
        else log( "Sin cebolla");
        log("");
        log(  "Bebida");
        log("Tipo:"+mipedbeb.getTipo());
        if (mipedbeb.getHielo()) log("Con hielo");
        else log("Sin hielo");
    }

    private void log(String s){
     logTexview.append(("\n" +s));
     scrollView.post( new Runnable(){
       @Override
       public void run(){
           scrollView.fullScroll(ScrollView.FOCUS_DOWN);
       }
     });

    }
}