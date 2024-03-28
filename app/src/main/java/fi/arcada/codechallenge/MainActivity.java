package fi.arcada.codechallenge;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView outputText;
    EditText inputText;

    double[] testdata = { 658457, 297132, 244223, 239206, 209551, 195137, 144473, 121543, 120027, 83482, 80454, 77261, 72634, 67971, 67615, 64736, 64180, 52122, 51400, 51241, 51149, 47909, 46880, 45988, 45226, 38959, 37232, 36493, 35497, 34884, 33533, 32622, 32547, 28521, 27484, 25655, 24810, 24260, 23998, 21333, 20958, 20695, 20197, 19982, 19973, 19767, 19702, 19579, 19097, 18344, 18318, 17253, 16573, 16467, 15808, 15628, 15463, 15357, 15312, 15165, 15086, 14643, 14203, 12890, 12669, 12662, 12412, 11742, 11197, 11041, 10543, 10396, 10396, 9877, 9870, 9563, 9562, 9443, 9423, 9311, 9117, 8978, 8717, 8563, 8456, 7979, 7928, 7759, 7702, 7497, 7105, 7102, 6951, 6891, 6877, 6802, 6785, 6613, 6506, 6465, 6380, 6286, 6070, 5484, 5390, 4964, 1289 };
    ArrayList<Double> values = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outputText = findViewById(R.id.outText);
        inputText = findViewById(R.id.inputText);

        // vi fyller vår ArrayList med värdena från testdata-arrayen
        for (double value : testdata) {
            values.add(value);
        }

        double version = 3.14159;
        int year = 2024;
        String author = "Fredde";

        Math.pow(4, 2); // 16
        Math.sqrt(16); // 4

        outputText.setText(String.format(
                "Appens version %.1f år %d by %s",
                version,
                year,
                author)
        );
    }

    public void calculate(View view) {

        outputText.setText(String.format(
                "Medelvärde: %.2f\nMedian: %.2f\nStandardavvikelse: %.2f",
                Statistics.calcMean(values),
                Statistics.calcMedian(values),
                Statistics.calcStdev(values)
        ));

    }

    public void buttonHandler(View view) {
        String text = inputText.getText().toString();
        outputText.setText(text);
    }
}