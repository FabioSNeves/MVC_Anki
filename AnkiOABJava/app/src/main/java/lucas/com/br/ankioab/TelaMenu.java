package lucas.com.br.ankioab;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TelaMenu extends AppCompatActivity {


    LerBaralhoTask lerBaralhoTask;
    ListarBaralhoTask listarBaralhoTask;
    Button addCarta, addBaralho;
    ListView listViewBaralho;
    EditText frenteCarta, versoCarta, nomeBaralho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_menu);

        addCarta = (Button) findViewById(R.id.botaoAddCard);
        addBaralho = (Button) findViewById(R.id.botaoAddDeck);
        listViewBaralho = (ListView) findViewById(R.id.listBaralhos);
        frenteCarta = (EditText) findViewById(R.id.card_front);
        versoCarta = (EditText) findViewById(R.id.card_back);
        nomeBaralho = (EditText) findViewById(R.id.form_deck_name);
        lerBaralhoTask = new LerBaralhoTask();

        // código para evitar erro de permissao no aplicativo android
        // ao acessar a internet:
        StrictMode.ThreadPolicy policy = new
                StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        listarBaralhoTask = new ListarBaralhoTask();

        ArrayList<Baralho> baralhos = preencherLista();
        ArrayAdapter<Baralho> arrayAdapter = new ArrayAdapter<Baralho>(this, android.R.layout.simple_list_item_1, baralhos);
        listViewBaralho.setAdapter(arrayAdapter);
    }

    private ArrayList<Baralho> preencherLista() {
        ArrayList<Baralho> dados = listarBaralhoTask.doInBackground();
        return dados;
    }

    public void adicionarCarta(View v) {
        Intent addCarta = new Intent(this, AdicionarCarta.class);
        startActivity(addCarta);
    }

    public void adicionarBaralho(View v) {
        Intent addBaralho = new Intent(this, AdicionarBaralho.class);
        startActivity(addBaralho);
    }

    public void game (View v) {
        Intent game = new Intent(this, Game.class);
        startActivity(game);
    }

}
