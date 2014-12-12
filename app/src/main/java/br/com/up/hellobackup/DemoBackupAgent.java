package br.com.up.hellobackup;

import android.app.backup.BackupAgentHelper;
import android.app.backup.BackupDataInput;
import android.app.backup.BackupDataOutput;
import android.app.backup.SharedPreferencesBackupHelper;
import android.os.ParcelFileDescriptor;

import java.io.IOException;

/**
 * Created by ricardo on 12/12/14.
 */
public class DemoBackupAgent extends BackupAgentHelper {
    @Override
    public void onBackup(ParcelFileDescriptor oldState, BackupDataOutput data,
                         ParcelFileDescriptor newState) throws IOException {
// A classe-mãe implementa isso...
        super.onBackup(oldState, data, newState);
    }
    @Override
    public void onRestore(BackupDataInput data, int appVersionCode, ParcelFileDescriptor
            newState) throws IOException {
// A classe-mãe implementa isso...
        super.onRestore(data, appVersionCode, newState);
    }
    @Override
    public void onCreate() {
// Cria um helper. A string "LivroAndroid" é a mesma chave utilizada
// pelo SharedPreferences
        SharedPreferencesBackupHelper helper = new SharedPreferencesBackupHelper(this,
                "LivroAndroid");
// Adiciona o helper ao agente de backups
        addHelper("livroAndroid", helper);
    }
}