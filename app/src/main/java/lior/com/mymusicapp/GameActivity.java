package lior.com.mymusicapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

    private TextView textScore, textTime;
    private EditText editTextAnswer;
    private Button btnSendAnswer;
    private MediaPlayer at_hasera_li, ein_yoter_moadonim, einaim, kapiyot, kshenigmeret_hasufa, ma_avar_alay, shampania,
            bailando, duele_el_corazon, el_bano, el_perdon, el_prededor, hero, subeme_la_radio,
            diamonds, love_the_way_you_lie, stay, umbrella, we_found_love, whats_my_name, wild_thoughts;
    private ArrayList<MediaPlayer> arrayListTotal = new ArrayList<>();
    private int score = 0, seconds = 30000, secondsShow = 30000, n1, idNum1;
    private Timer myTimer;
    private CountDownTimer countDownTimer;
    private Random rand = new Random();
    private SharedPreferences.Editor editorRand;
    private SharedPreferences prefsRand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        textScore = findViewById(R.id.textScore);
        textTime = findViewById(R.id.textTime);
        editTextAnswer = findViewById(R.id.editTextAnswer);
        btnSendAnswer = findViewById(R.id.btnSendAnswer);

        getPref();
        getDelRandomData();
        resetCountDownTimer();
        resetTimer();
        getTimer();

        idNum1 = prefsRand.getInt("random1", 5000);

        at_hasera_li = MediaPlayer.create(GameActivity.this, R.raw.at_hasera_li);
        ein_yoter_moadonim = MediaPlayer.create(GameActivity.this, R.raw.ein_yoter_moadonim);
        einaim = MediaPlayer.create(GameActivity.this, R.raw.einaim);
        kapiyot = MediaPlayer.create(GameActivity.this, R.raw.kapiyot);
        kshenigmeret_hasufa = MediaPlayer.create(GameActivity.this, R.raw.kshenigmeret_hasufa);
        ma_avar_alay = MediaPlayer.create(GameActivity.this, R.raw.ma_avar_alay);
        shampania = MediaPlayer.create(GameActivity.this, R.raw.shampania);
        bailando = MediaPlayer.create(GameActivity.this, R.raw.bailando);
        duele_el_corazon = MediaPlayer.create(GameActivity.this, R.raw.duele_el_corazon);
        el_bano = MediaPlayer.create(GameActivity.this, R.raw.el_bano);
        el_perdon = MediaPlayer.create(GameActivity.this, R.raw.el_perdon);
        el_prededor = MediaPlayer.create(GameActivity.this, R.raw.el_prededor);
        hero = MediaPlayer.create(GameActivity.this, R.raw.hero);
        subeme_la_radio = MediaPlayer.create(GameActivity.this, R.raw.subeme_la_radio);
        diamonds = MediaPlayer.create(GameActivity.this, R.raw.diamonds);
        love_the_way_you_lie = MediaPlayer.create(GameActivity.this, R.raw.love_the_way_you_lie);
        stay = MediaPlayer.create(GameActivity.this, R.raw.stay);
        umbrella = MediaPlayer.create(GameActivity.this, R.raw.umbrella);
        we_found_love = MediaPlayer.create(GameActivity.this, R.raw.we_found_love);
        whats_my_name = MediaPlayer.create(GameActivity.this, R.raw.whats_my_name);
        wild_thoughts = MediaPlayer.create(GameActivity.this, R.raw.wild_thoughts);

        initAddSongs(arrayListTotal, at_hasera_li, ein_yoter_moadonim, einaim, kapiyot, kshenigmeret_hasufa, ma_avar_alay, shampania,
                bailando, duele_el_corazon, el_bano, el_perdon, el_prededor, hero, subeme_la_radio,
                diamonds, love_the_way_you_lie, stay, umbrella, we_found_love, whats_my_name, wild_thoughts);

        btnSendAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musicMethod(arrayListTotal, 0, "את חסרה לי", editTextAnswer);
                musicMethod(arrayListTotal, 1, "אין יותר מועדונים", editTextAnswer);
                musicMethod(arrayListTotal, 2, "עיניים", editTextAnswer);
                musicMethod(arrayListTotal, 3, "כפיות", editTextAnswer);
                musicMethod(arrayListTotal, 4, "כשנגמרת הסופה", editTextAnswer);
                musicMethod(arrayListTotal, 5, "מה עבר עלי", editTextAnswer);
                musicMethod(arrayListTotal, 6, "שמפניה", editTextAnswer);
                musicMethod(arrayListTotal, 7, "Bailando", editTextAnswer);
                musicMethod(arrayListTotal, 8, "Duele el corazon", editTextAnswer);
                musicMethod(arrayListTotal, 9, "El bano", editTextAnswer);
                musicMethod(arrayListTotal, 10, "El perdon", editTextAnswer);
                musicMethod(arrayListTotal, 11, "El Prededor", editTextAnswer);
                musicMethod(arrayListTotal, 12, "Hero", editTextAnswer);
                musicMethod(arrayListTotal, 13, "Subeme la radio", editTextAnswer);
                musicMethod(arrayListTotal, 14, "Diamonds", editTextAnswer);
                musicMethod(arrayListTotal, 15, "Love the way you lie me", editTextAnswer);
                musicMethod(arrayListTotal, 16, "Stay", editTextAnswer);
                musicMethod(arrayListTotal, 17, "Umbrella", editTextAnswer);
                musicMethod(arrayListTotal, 18, "We found love", editTextAnswer);
                musicMethod(arrayListTotal, 19, "Whats my name", editTextAnswer);
                musicMethod(arrayListTotal, 20, "Wild thoughts", editTextAnswer);

                textScore.setText(String.valueOf(score));

                if (score == 60) {
                    seconds = 35000;

                    resetCountDownTimer();
                    resetTimer();
                    getTimer();
                }
            }
        });
    }

    private void initAddSongs(ArrayList<MediaPlayer> arrayListCountry,
                              MediaPlayer song1, MediaPlayer song2, MediaPlayer song3, MediaPlayer song4, MediaPlayer song5, MediaPlayer song6, MediaPlayer song7,
                              MediaPlayer song8, MediaPlayer song9, MediaPlayer song10, MediaPlayer song11, MediaPlayer song12, MediaPlayer song13, MediaPlayer song14,
                              MediaPlayer song15, MediaPlayer song16, MediaPlayer song17, MediaPlayer song18, MediaPlayer song19, MediaPlayer song20, MediaPlayer song21) {
        arrayListCountry.add(song1);
        arrayListCountry.add(song2);
        arrayListCountry.add(song3);
        arrayListCountry.add(song4);
        arrayListCountry.add(song5);
        arrayListCountry.add(song6);
        arrayListCountry.add(song7);
        arrayListCountry.add(song8);
        arrayListCountry.add(song9);
        arrayListCountry.add(song10);
        arrayListCountry.add(song11);
        arrayListCountry.add(song12);
        arrayListCountry.add(song13);
        arrayListCountry.add(song14);
        arrayListCountry.add(song15);
        arrayListCountry.add(song16);
        arrayListCountry.add(song17);
        arrayListCountry.add(song18);
        arrayListCountry.add(song19);
        arrayListCountry.add(song20);
        arrayListCountry.add(song21);

        if (idNum1 == 5000) {
            getRandom();
            getEditorPrefs(n1);
            arrayListCountry.get(n1).start();
        }
    }

    private void musicMethod(ArrayList<MediaPlayer> arrayListCountry, int numArr, String answer, EditText etAnswer) {
        if (arrayListCountry.get(numArr).isPlaying()) {
            if (etAnswer.getText().toString().equals(answer)) {
                arrayListCountry.get(numArr).pause();
                etAnswer.setText("");
                score = score + 20;
                getDelRandomData();
                if (idNum1 == 5000) {
                    getRandom();
                    getEditorPrefs(n1);
                    arrayListCountry.get(n1).start();
                }
            }
        }
    }

    private void getRandom() {
        rand = new Random();
        n1 = rand.nextInt(20);
    }

    private void getEditorPrefs(int num1) {
        editorRand = getSharedPreferences("random", MODE_PRIVATE).edit();
        editorRand.putInt("random1", num1).apply();
    }

    private void getPref() {
        prefsRand = getSharedPreferences("random", MODE_PRIVATE);
    }

    private void getDelRandomData() {
        prefsRand.edit().clear().commit();
    }

    private void getTimer() {
        myTimer = new Timer();
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                TimerMethod();
                getFinish();
            }
        }, 0, seconds);
    }

    private void TimerMethod() {
        this.runOnUiThread(Timer_Tick);
    }

    private Runnable Timer_Tick = new Runnable() {
        @Override
        public void run() {
            GameActivity.this.resetCountDownTimer();
            GameActivity.this.getMySeconds();
        }
    };

    private void getMySeconds() {
        countDownTimer = new CountDownTimer(seconds, 1) {
            public void onTick(long millisUntilFinished) {
                secondsShow = Math.round(millisUntilFinished / 1000);
                textTime.setText("נשארו: " + secondsShow + " שניות");
            }

            public void onFinish() {

            }
        }.start();
    }

    private void resetCountDownTimer() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
            countDownTimer = null;
        }
    }

    private void resetTimer() {
        if (myTimer != null) {
            myTimer.cancel();
            myTimer = null;
        }
    }

    private void getFinish() {
        if (secondsShow == 0 || score == 140) {
            resetCountDownTimer();
            resetTimer();

            initStopMusic(arrayListTotal);

            Intent intent = new Intent(GameActivity.this, FinishActivity.class);
            intent.putExtra("score", score);
            startActivity(intent);

            finish();
        }
    }

    private void initStopMusic(ArrayList<MediaPlayer> arrayListCountry) {
        for (int i = 0; i < arrayListCountry.size(); i++) {
            arrayListCountry.get(i).stop();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        initStopMusic(arrayListTotal);
    }

    @Override
    protected void onStop() {
        super.onStop();

        initStopMusic(arrayListTotal);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        initStopMusic(arrayListTotal);
    }

}
