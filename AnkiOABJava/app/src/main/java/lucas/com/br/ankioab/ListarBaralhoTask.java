package lucas.com.br.ankioab;

import android.os.AsyncTask;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import feign.Feign;
import feign.gson.GsonDecoder;

/**
 * Created by lucas on 28/09/2017.
 */

public class ListarBaralhoTask extends AsyncTask<Void, Void, ArrayList> {
    @Override
    protected ArrayList<Baralho> doInBackground(Void... params) {
        try {
            // 1. usando a Feign para fazer uma chamada a uma api rest
            BaralhoRequest request = Feign.builder().
                    decoder(new GsonDecoder()).
                    target(BaralhoRequest.class, "http://192.168.1.102/Anki2");

            // 2. Fazendo a chamada e recuperando o objeto convertido
            ArrayList<Baralho> baralhos = request.getAllBaralho();
            return baralhos;

        } catch (Exception e) {
            System.err.println("Erro na chamada à API "+e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
