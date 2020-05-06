package lior.com.mymusicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class FinishActivity extends AppCompatActivity {

    private TextView textScoreTotal;
    private ArrayList<SongModel> mSongList = new ArrayList<>();
    private SongCustomAdapter mAdapter;
    private SongDBHelper mSongDBHelper;
    private RecyclerView recyclerView;
    private ItemDecoration itemDecoration;
    private String urlEdenHason = "https://www.israelhayom.co.il/sites/default/files/u55081/FADIDA_0.jpg";
    private String urlEnriqueIglesias = "https://www.kindpng.com/picc/m/79-795370_enrique-iglesias-png-transparent-png.png";
    private String urlRihanna = "https://upload.wikimedia.org/wikipedia/commons/c/c2/Rihanna_Fenty_2018.png";
    private int myScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        textScoreTotal = findViewById(R.id.textScoreTotal);
        recyclerView = findViewById(R.id.recyclerView);

        Bundle extras = getIntent().getExtras();
        myScore = extras.getInt("score");
        textScoreTotal.setText(String.valueOf(myScore));

        mSongDBHelper = new SongDBHelper(this);

        mSongDBHelper.deleteData();
        mSongDBHelper.addSong("Eden Hason", "עדן חסון - את חסרה לי | Eden Hason - At Hasera Li", urlEdenHason);
        mSongDBHelper.addSong("Eden Hason", "עדן חסון - מה עבר עליי | Eden Hason - Ma Avar Alay", urlEdenHason);
        mSongDBHelper.addSong("Eden Hason", "עדן חסון - כשנגמרת הסופה | Eden Hason - Kshenigmeret Hasufa", urlEdenHason);
        mSongDBHelper.addSong("Eden Hason", "עדן חסון - אין יותר מועדונים Prod. By Stav Beger) Eden Hason)", urlEdenHason);
        mSongDBHelper.addSong("Eden Hason", "עדן חסון - כפיות | Eden Hason - Kapiyot", urlEdenHason);
        mSongDBHelper.addSong("Eden Hason", "עדן חסון - עיניים | Eden Hason - Einaim", urlEdenHason);
        mSongDBHelper.addSong("Eden Hason", "עדן חסון - שמפניה | Eden Hason - Shampania", urlEdenHason);
        mSongDBHelper.addSong("Enrique Iglesias", "Enrique Iglesias - Bailando ft. Descemer Bueno, Gente De Zona (Español)", urlEnriqueIglesias);
        mSongDBHelper.addSong("Enrique Iglesias", "21. El Perdón - Nicky Jam y Enrique Iglesias [Official Music Video YTMAs]", urlEnriqueIglesias);
        mSongDBHelper.addSong("Enrique Iglesias", "Enrique Iglesias - SUBEME LA RADIO (Official Video) ft. Descemer Bueno, Zion & Lennox", urlEnriqueIglesias);
        mSongDBHelper.addSong("Enrique Iglesias", "Enrique Iglesias - EL BAÑO ft. Bad Bunny", urlEnriqueIglesias);
        mSongDBHelper.addSong("Enrique Iglesias", "Enrique Iglesias - El Perdedor ft. Marco Antonio Solís", urlEnriqueIglesias);
        mSongDBHelper.addSong("Enrique Iglesias", "Enrique Iglesias - DUELE EL CORAZON ft. Wisin", urlEnriqueIglesias);
        mSongDBHelper.addSong("Enrique Iglesias", "Enrique Iglesias - Hero", urlEnriqueIglesias);
        mSongDBHelper.addSong("Rihanna", "Rihanna - Diamonds", urlRihanna);
        mSongDBHelper.addSong("Rihanna", "DJ Khaled ft. Rihanna, Bryson Tiller - Wild Thoughts (Official Video)", urlRihanna);
        mSongDBHelper.addSong("Rihanna", "Rihanna - Umbrella (Orange Version) (Official Music Video) ft. JAY-Z", urlRihanna);
        mSongDBHelper.addSong("Rihanna", "Rihanna - What's My Name? (Official Music Video) ft. Drake", urlRihanna);
        mSongDBHelper.addSong("Rihanna", "Rihanna - Stay ft. Mikky Ekko", urlRihanna);
        mSongDBHelper.addSong("Rihanna", "Rihanna - We Found Love ft. Calvin Harris", urlRihanna);
        mSongDBHelper.addSong("Rihanna", "Eminem - Love The Way You Lie ft. Rihanna", urlRihanna);

        mAdapter = new SongCustomAdapter(this, mSongList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        if (itemDecoration == null) {
            itemDecoration = new ItemDecoration(20);
            recyclerView.addItemDecoration(itemDecoration);
        }
        recyclerView.setAdapter(mAdapter);

        getData();
    }

    private void getData() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                mSongList.clear();
                mSongList.addAll(mSongDBHelper.getAllSongs());
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                mAdapter.notifyDataSetChanged();
            }
        }.execute();
    }

}
