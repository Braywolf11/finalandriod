package com.example.shoppingcard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Shoppingcart extends AppCompatActivity {
    EditText Enombreproduct,Equantity;
    Button guardar;
    ListView lv ;
    ArrayList<String> lista;
    ArrayAdapter adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        Enombreproduct=(EditText)findViewById(R.id.txtproduct);
        Equantity=(EditText)findViewById(R.id.txtquantity);
        guardar=(Button)findViewById(R.id.btnadd);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DB db= new DB(getApplicationContext(),null,null,1);
                String nombre = Enombreproduct.getText().toString();
                String quantity =Equantity.getText().toString();
                String mensaje =db.guardar(nombre, quantity);
                Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_SHORT).show();

            }

        });
        lv = (ListView)findViewById(R.id.lista);
        DB db = new DB(getApplicationContext(),null,null,1);
        lista = db.llenar_lv();
        adaptador = new ArrayAdapter(this, android.R.layout.select_dialog_item,lista);
        lv.setAdapter(adaptador);
    }
}
