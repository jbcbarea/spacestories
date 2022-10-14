package edu.uoc.cardview;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.preference.PreferenceManager;

import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.load.model.UrlUriLoader;

import java.io.IOException;
import java.util.ArrayList;

import static android.view.View.FOCUS_DOWN;
import static android.view.View.FOCUS_UP;

public class ContentCuentos extends AppCompatActivity implements MediaController.MediaPlayerControl {

    private ConexionSQLite sq;
    private UtilitiesSQL utilitiesSQL;
    public static ArrayList<ContentCuentos> cuentosContenido = new ArrayList<>();
    private int Id;
    private TextView textViewContent;
    private MediaPlayer mp;
    private MediaController mc;
    private boolean playPauseFirstTime = true;
    private Handler h;
    private int[] audios;
    private TextView title, moraleja;
    private ImageView imageView;
    private MainAdapter mainAdapter;
    private View viewBackground;
    private ScrollView scrollView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_cuentos);

        ActionBar actionBar = getSupportActionBar();
        //actionBar.setTitle("Spa");
        //actionBar.setSubtitle("  edit what you like");
        actionBar.setLogo(R.drawable.rocket);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);


        //getSupportActionBar().setBackgroundDrawable(ColorDrawable.createFromPath("#0096FF"));
        audios = new int[]{R.raw.simbad, R.raw.bremen,R.raw.simbad,R.raw.simbad,R.raw.simbad,R.raw.simbad,R.raw.simbad,R.raw.simbad,R.raw.simbad,R.raw.simbad,
                R.raw.simbad, R.raw.bremen,R.raw.simbad,R.raw.simbad,R.raw.simbad,R.raw.simbad,R.raw.simbad,R.raw.simbad,R.raw.simbad,R.raw.simbad,R.raw.simbad,
                R.raw.bremen,R.raw.simbad,R.raw.simbad,R.raw.simbad,R.raw.simbad,R.raw.simbad,R.raw.simbad,R.raw.simbad,R.raw.simbad,
                R.raw.simbad, R.raw.bremen,R.raw.simbad,R.raw.simbad,R.raw.simbad,R.raw.simbad,R.raw.bremen,R.raw.princesspee,R.raw.belladurmiente,R.raw.mermaid,R.raw.rapunzel,R.raw.velvetrabbit};

        sq = new ConexionSQLite(getApplicationContext(), "MisCUENTOS", null, 1);
        sq = new ConexionSQLite(getApplicationContext(), "TIPOCUENTO", null, 1);
        sq = new ConexionSQLite(getApplicationContext(), "MisCONTENIDOCUENTOS", null, 1);
        utilitiesSQL = new UtilitiesSQL();
        getIncomingIntent();
        utilitiesSQL.consultFromSQLiteContenidoCuentos(sq, Id);
        textViewContent = findViewById(R.id.textViewContent);
        title = findViewById(R.id.titleTextView);
        moraleja = findViewById(R.id.moralejabueno);
        imageView = findViewById(R.id.imageViewCuentos);
        viewBackground = findViewById(R.id.background);
        scrollView = (ScrollView) findViewById(R.id.scrollView);
        imageView.setImageResource(mainAdapter.imgCuentos[Id - 1]);
        moraleja.setText(UtilitiesSQL.pruebaContenido.get(0).getMoraleja());
        title.setText(UtilitiesSQL.pruebaContenido.get(0).getTitle());

        textViewContent.setText(utilitiesSQL.pruebaContenido.get(0).getContenido());
        loadpreferences();

        //A lo mejor puedo llamar al mp.setDataSource y le paso la direccion
        mp = MediaPlayer.create(getApplicationContext(), audios[Id-1]);
        mc = new MediaController(getApplicationContext());
        mc = findViewById(R.id.mediaController);
        mc.setAnchorView(findViewById(R.id.constraint));
        mc.setMediaPlayer(this);
        h = new Handler();
        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                h.post(new Runnable() {
                    @Override
                    public void run() {
                        mc.show(0);
                    }
                });
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mp.stop();
        mp.reset();
    }

    public void getIncomingIntent() {

        if (getIntent().hasExtra("Id")) {

            //Sacar la fecha Telefono, nombre , id........
            Id = getIntent().getIntExtra("Id", 1);
            System.out.println(Id);
        }
    }

    @Override
    public void start() {
        if (!mp.isPlaying()) {
            mp.start();

            if(getCurrentPosition()==0) {
                scrollView.fullScroll(FOCUS_UP);
            }
         //   if(playPauseFirstTime==true){
          //      scrollView.fullScroll(FOCUS_UP);
          //  }
        }

    }

    @Override
    public void pause() {
        if (mp.isPlaying())
            mp.pause();
            playPauseFirstTime =false;
    }

    @Override
    public int getDuration() {
        return mp.getDuration();
    }

    @Override
    public int getCurrentPosition() {
        return mp.getCurrentPosition();
    }

    @Override
    public void seekTo(int i) {
        mp.seekTo(i);
    }

    @Override
    public boolean isPlaying() {
        return mp.isPlaying();

    }

    @Override
    public int getBufferPercentage() {
        return 0;
    }

    @Override
    public boolean canPause() {
        return true;
    }

    @Override
    public boolean canSeekBackward() {
        return true;
    }

    @Override
    public boolean canSeekForward() {
        return true;
    }

    @Override
    public int getAudioSessionId() {
        return mp.getAudioSessionId();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_POINTER_DOWN)
            if (!mc.isShowing())
                mc.show(0);
            else
                mc.hide();
        return false;
    }

    public void loadpreferences() {

        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(this /* Activity context */);

        String colorText = sharedPreferences.getString("color", "Por Defecto");
        if (colorText.equals("Verde")) {
            textViewContent.setTextColor(Color.parseColor("#FF018786"));
            moraleja.setTextColor(Color.parseColor("#FF018786"));
            title.setTextColor(Color.parseColor("#FF018756"));
        }
        if (colorText.equals("Azul")) {
            textViewContent.setTextColor(Color.parseColor("#5800FF"));
            moraleja.setTextColor(Color.parseColor("#5800FF"));
            title.setTextColor(Color.parseColor("#5856FF"));
        }

        String colorBackground = sharedPreferences.getString("colorFondo", "Por Defecto");
        if (colorBackground.equals("Azulado")) {

            viewBackground.setBackgroundColor(Color.parseColor("#E8F9FD"));
        }

        String sizeText = sharedPreferences.getString("tamaño", "Mediana");
        if (sizeText.equals("Pequeña")) {
            textViewContent.setTextSize(15);
            moraleja.setTextSize(15);
            title.setTextSize(15);
        }
        if (sizeText.equals("Mediana")) {
            textViewContent.setTextSize(20);
            moraleja.setTextSize(20);
            title.setTextSize(20);
        }
        if (sizeText.equals("Grande")) {
            textViewContent.setTextSize(25);
            moraleja.setTextSize(25);
            title.setTextSize(25);
        }
        String fontText = sharedPreferences.getString("font", "RobotoMonoVariable");
        if (fontText.equals("M1")) {
            Typeface face = ResourcesCompat.getFont(getApplicationContext(), R.font.m1);
            textViewContent.setTypeface(face);
            moraleja.setTypeface(face);
            title.setTypeface(face,Typeface.BOLD);
        }
        if (fontText.equals("RobotoItalic")) {
            Typeface face = ResourcesCompat.getFont(getApplicationContext(), R.font.roboto);
            textViewContent.setTypeface(face);
            moraleja.setTypeface(face);
            title.setTypeface(face,Typeface.BOLD);
        }
        if (fontText.equals("MontserratAlter")) {
            Typeface face = ResourcesCompat.getFont(getApplicationContext(), R.font.montserrat);
            textViewContent.setTypeface(face);
            moraleja.setTypeface(face);
            title.setTypeface(face,Typeface.BOLD);
        }
    }
}