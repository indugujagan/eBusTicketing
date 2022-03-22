package za.co.jooce.ebus;

import android.content.res.AssetFileDescriptor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import za.co.jooce.ebus.dao.DataSourceFactory;

public class MainActivity extends AppCompatActivity {

    private TextView readCardTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        readCardTextView = findViewById(R.id.readCardTextView);

        Button readCardButton = findViewById(R.id.readCardButton);
        View.OnClickListener readWriteButtonListener = getReadCardButtonListener();
        readCardButton.setOnClickListener(readWriteButtonListener);

        Button signOnButton = findViewById(R.id.signOnbutton);
        View.OnClickListener signOffButtonListener = getSignOnButtonListener();
        signOnButton.setOnClickListener(signOffButtonListener);

        Button buzzerButton = findViewById(R.id.buzzerButton);
        View.OnClickListener buzzerButtonListener = getBuzzerButtonListener();
        buzzerButton.setOnClickListener(buzzerButtonListener);

        Button playSounds = findViewById(R.id.playSoundsButton);
        View.OnClickListener playSoundsListener = getPlaySoundsButtonListener();
        playSounds.setOnClickListener(playSoundsListener);

        Button redLedButton = findViewById(R.id.redLedButton);
        View.OnClickListener redLedButtonListener = getRedLEDButtonListener();
        redLedButton.setOnClickListener(redLedButtonListener);

        Button greenLedButton = findViewById(R.id.greenLedButton);
        View.OnClickListener greenLedButtonListener = getGreenLEDButtonListener();
        greenLedButton.setOnClickListener(greenLedButtonListener);
    }

    private View.OnClickListener getReadCardButtonListener() {
        return view -> readCardTextView.setText(DataSourceFactory.getCardDevice().readCardCopyOne());

    }

    private View.OnClickListener getSignOnButtonListener() {
        return view -> readCardTextView.setText(DataSourceFactory.getCardDevice().signOnCard());
    }
    private View.OnClickListener getSignOffButtonListener() {
        return view -> readCardTextView.setText(DataSourceFactory.getCardDevice().signOffCard());
    }

    private View.OnClickListener getBuzzerButtonListener() {
        return view -> readCardTextView.setText(DataSourceFactory.getCardDevice().scanCardSectorsTwo());
    }

    private View.OnClickListener getPlaySoundsButtonListener() {
        try {
            AssetFileDescriptor afd = getAssets().openFd("voice/hello.wav");
            return view -> readCardTextView.setText(DataSourceFactory.getCardDevice().playSounds(afd, this));
        } catch (IOException e) {
            return view -> readCardTextView.setText(e.getMessage());
        }
    }

    private View.OnClickListener getRedLEDButtonListener() {
        return view -> readCardTextView.setText(DataSourceFactory.getCardDevice().redLED());
    }

    private View.OnClickListener getGreenLEDButtonListener() {
        return view -> readCardTextView.setText(DataSourceFactory.getCardDevice().greenLED());
    }
}