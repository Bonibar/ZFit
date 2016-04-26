package fr.zwertv.zfit;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;

public class AddExerciceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercice);
    }

    public void cancelActivity(View view) {
        setResult(RESULT_CANCELED);
        this.finish();
    }

    public void addExercice(View view) {
        AutoCompleteTextView title = (AutoCompleteTextView) findViewById(R.id.title_exercice);
        String userInput = title.getText().toString();

        if (userInput.length() > 0) {
            Intent returnvalue = new Intent();
            returnvalue.putExtra("exercice_title", userInput);
            setResult(RESULT_OK, returnvalue);
            this.finish();
        } else {
            title.setError("Please enter a valid title");
        }
    }
}
