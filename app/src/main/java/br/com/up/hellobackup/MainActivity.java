package br.com.up.hellobackup;

import android.app.backup.BackupManager;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


/**
 * Main
 */
public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private static final String TAG = "livro";
    private BackupManager backupManager;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);

        // Cria o gerenciador de backup
        backupManager = new BackupManager(this);

// Recupera o valor do flag salvo nas preferencias
        SharedPreferences pref = getSharedPreferences("LivroAndroid", 0);
// O segundo argumento é o valor default se não encontrar
        String nome = pref.getString("nome","");
        Log.i(TAG, "Nome prefs: " + nome);
        EditText text = (EditText) findViewById(R.id.text);
        text.setText(nome);
        Button btSalvar = (Button) findViewById(R.id.btSalvar);
        btSalvar.setOnClickListener(this);
    }
    /**
     * @see android.view.View.OnClickListener#onClick(android.view.View)
     */
    public void onClick(View view) {
// Salva o flag nas preferências
        SharedPreferences pref = getSharedPreferences("LivroAndroid", MODE_PRIVATE);
// Abre a preferência para edição
        SharedPreferences.Editor editor = pref.edit();
        EditText text = (EditText) findViewById(R.id.text);
        String nome = text.getText().toString();
// Atualiza o valor
        editor.putString("nome", nome);
        Log.i(TAG, "Nome salvo para: " + nome);
// Faz commit para salvar os dados
        editor.commit();

        // Avisa o backup de que os dados foram alterados
        backupManager.dataChanged();
    }
}
