package fi.arcada.codechallenge;

import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    double[] temps = {-4.7, -4.8, -1.8, 0.7, 0.1, -6, -7.8, -7, -3.8, -10.6, -10.3, -0.3, 4.8, 2.6, 0.1, 1.2, -1.5, -2.7, 1.8, 0.2, -2, -5.5, -1.3, 2.1, -0.6, -0.9, 1, -0.5, -1.4, -1.6, -5.3, -7.7, -8.2, -9.5, -3.9, -0.4, 1, 0.8, -0.4, 0.6, 1, -1.5, -0.5, 1.4, 1.5, 1.8, 2, 1.1, -0.1, 0.1, -0.7, -0.4, -3, -6.8, 2, 1.5, -1.3, -0.2, 1.6, 1.9, 1.3, 0.6, -2, -2.4, 0.8, -0.3, -2.5, -2.6, -0.7, 1.8, 1.3, 0.9, 3, 0.7, 0.8, 1.6, 2.5, 2, 6.2};
    LineChart chart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chart = (LineChart) findViewById(R.id.chart);

        //simpleChart(temps, "Temperatur");

        ArrayList<DataLine> dataLines = new ArrayList<>();
        dataLines.add(new DataLine(temps, "Temperatur", Color.BLUE, 0));
        dataLines.add(new DataLine(Statistics.sma(temps, 10), "SMA-10", Color.RED, 9));
        dataLines.add(new DataLine(Statistics.sma(temps, 20), "SMA-20", Color.GREEN, 19));
        improvedChart(dataLines);

    }

    public void improvedChart(ArrayList<DataLine> dataLines) {

        List<ILineDataSet> dataSeries = new ArrayList<>();

        for (DataLine dataLine: dataLines) {
            LineDataSet lineDataSet = new LineDataSet(
                    dataLine.getEntries(), dataLine.getLabel()
            );
            lineDataSet.setDrawValues(false);
            lineDataSet.setDrawCircles(false);
            lineDataSet.setColor(dataLine.getColor());

            dataSeries.add(lineDataSet);
        }

        LineData lineData = new LineData(dataSeries);

        chart.setData(lineData);
        chart.invalidate();

    }

    public void simpleChart(double[] values, String label) {

        List<Entry> entries = new ArrayList<>();

        for (int i = 0; i < values.length; i++) {
            entries.add(new Entry(i, (float) values[i]));
        }
        LineDataSet lineDataSet = new LineDataSet(entries, label);
        lineDataSet.setDrawValues(false);
        lineDataSet.setDrawCircles(false);
        lineDataSet.setColor(Color.RED);

        LineData lineData = new LineData(lineDataSet);

        chart.setData(lineData);
        chart.invalidate();

    }



}