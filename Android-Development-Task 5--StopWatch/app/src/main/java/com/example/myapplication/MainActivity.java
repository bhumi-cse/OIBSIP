package com.example.myapplication; 
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView clockView;
    private Button startBtn, pauseBtn, resetBtn;

    private int elapsedSeconds = 0;
    private boolean isActive = false;
    private boolean isPausedState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clockView = findViewById(R.id.clockView);
        startBtn = findViewById(R.id.startBtn);
        pauseBtn = findViewById(R.id.pauseBtn);
        resetBtn = findViewById(R.id.resetBtn);

        if (savedInstanceState != null) {
            elapsedSeconds = savedInstanceState.getInt("sec_count");
            isActive = savedInstanceState.getBoolean("is_active");
            isPausedState = savedInstanceState.getBoolean("was_paused");
            toggleControls();
        }

        startTimerEngine();

        startBtn.setOnClickListener(v -> {
            isActive = true;
            toggleControls();
        });

        pauseBtn.setOnClickListener(v -> {
            isActive = false;
            toggleControls();
        });

        resetBtn.setOnClickListener(this::onClick);
   }

    @Override
    protected void onPause() {
        super.onPause();
        isPausedState = isActive;
        isActive = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isPausedState) {
            isActive = true;
            toggleControls();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("sec_count", elapsedSeconds);
        outState.putBoolean("is_active", isActive);
        outState.putBoolean("was_paused", isPausedState);
    }

    private void toggleControls() {
        startBtn.setEnabled(!isActive);
        startBtn.setAlpha(isActive ? 0.5f : 1.0f);
        pauseBtn.setEnabled(isActive);
        pauseBtn.setAlpha(isActive ? 1.0f : 0.5f);
    }

    private void startTimerEngine() {
        Handler timerHandler = new Handler(Looper.getMainLooper());
        timerHandler.post(new Runnable() {
            @Override
            public void run() {
                int hrs = elapsedSeconds / 3600;
                int mins = (elapsedSeconds % 3600) / 60;
                int secs = elapsedSeconds % 60;

                String formattedTime = String.format(Locale.US, "%02d:%02d:%02d", hrs, mins, secs);

                if (isActive) {
                    clockView.setText(formattedTime);
                    elapsedSeconds++;
                }

                timerHandler.postDelayed(this, 1000);
            }
        });
    }

    private void onClick(View v) {
        isActive = false;
        elapsedSeconds = 0;
        toggleControls();
        clockView.setText(R.string._00_00_00);
    }
}