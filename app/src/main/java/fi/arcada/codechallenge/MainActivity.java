package fi.arcada.codechallenge;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    TextView outputText;
    EditText inputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outputText = findViewById(R.id.outText);
        inputText = findViewById(R.id.inputText);

        outputText.setText("Skriv ett heltal");
    }

    public void buttonHandler(View view) {

        try {
            int number = Integer.parseInt(inputText.getText().toString());
            outputText.setText(String.format("Du skrev %d", number));
        } catch (NumberFormatException e) {

            Toast.makeText(this, "Det där var inget heltal!", Toast.LENGTH_LONG).show();

            // "Snackbar" kan användas för mer avancerade egenskaper

        }

    }
}