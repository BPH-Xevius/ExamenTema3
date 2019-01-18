package educacion.trax.acbproyectoandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;

public class NomProf extends AppCompatActivity {

    MyDBAdapter table=new MyDBAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nom_prof);

        final TextView mostrar=findViewById(R.id.result);
        final TextView nombre=findViewById(R.id.busqueda);

        table.open();
        final Button buscar=findViewById(R.id.buscar);
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrar.setText("");
                String nomb= String.valueOf(nombre.getText());
                ArrayList<String> profes =table.recuperarProfesName(nomb);
                Iterator it=profes.iterator();
                while(it.hasNext()){
                    String prof= String.valueOf(it.next());
                    mostrar.setText(""+mostrar.getText()+"\n"+prof);
                }
            }
        });

    }
}
