package lior.com.mymusicapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnStartGame;
    private MediaPlayer startApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startApp = MediaPlayer.create(MainActivity.this, R.raw.start_app);
        btnStartGame = findViewById(R.id.btnStartGame);

        startApp.start();

        btnStartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentStartGame = new Intent(MainActivity.this, GameActivity.class);
                startActivity(intentStartGame);
            }
        });
    }

}
