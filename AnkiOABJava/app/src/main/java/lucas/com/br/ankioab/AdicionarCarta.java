package lucas.com.br.ankioab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class AdicionarCarta extends AppCompatActivity {

    Button addCarta;
    EditText card_front, card_back;
    CriarCartaTask criarCartaTask;
    Spinner spn_deck_id;
    ListarBaralhoTask listarBaralhoTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_carta);

        addCarta = (Button) findViewById(R.id.botaoAddCard);
        card_front = (EditText) findViewById(R.id.card_front);
        card_back = (EditText) findViewById(R.id.card_back);

        listarBaralhoTask = new ListarBaralhoTask();
    }

    public ArrayList<Baralho> listarBaralho ()
    {
        ArrayList<Baralho> baralhos = listarBaralhoTask.doInBackground();
        return baralhos;


    }
}
