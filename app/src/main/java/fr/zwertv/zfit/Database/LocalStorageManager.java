package fr.zwertv.zfit.Database;

import android.content.Context;
import android.content.ContextWrapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Elliott on 31/03/2016.
 */
public class LocalStorageManager extends ContextWrapper {

    public LocalStorageManager(Context base) {
        super(base);
    }

    public String load(String filename) throws FileNotFoundException {
        File file = new File(this.getFilesDir(), filename);

        StringBuilder builder = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                builder.append(line);
                builder.append('\n');
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return builder.toString();
    }

    public void append(String filename, String data) throws FileNotFoundException {
        try {
            FileOutputStream t = openFileOutput(filename, Context.MODE_PRIVATE | Context.MODE_APPEND);
            t.write(data.getBytes());
            t.close();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void remove(String filename) {
        File file = new File(this.getFilesDir(), filename);
        file.delete();
    }

    private void create(String filename) {
        File file = new File(this.getFilesDir(), filename);
        file.setWritable(true, true);
    }

    public void empty(String filename) {
        remove(filename);
        create(filename);
    }
}
