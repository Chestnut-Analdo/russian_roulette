package ru.rotanov.russian_roulette;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.jar.Attributes;

public class MainActivity extends Activity {

    private SoundPool sounds;
    private int sound_Shot;

    private int sound_missfire;

    private int soung_dumb;

    private ImageView blood_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AudioAttributes attributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();
        sounds = new SoundPool.Builder()
                .setAudioAttributes(attributes)
                .build();
        loadSounds();
        blood_image = findViewById(R.id.imageView2);
    }


    private void loadSounds() {
        sound_Shot = sounds.load(this, R.raw.revolver_shot, 1);
        sound_missfire = sounds.load(this, R.raw.gun_false, 1);
        soung_dumb = sounds.load(this, R.raw.revolver_baraban, 1);
    }

    public void onShot(View view) {
        sounds.play(sound_Shot, 1.0f, 1.0f, 1, 0, 1);
        blood_image.setVisibility(View.VISIBLE);
    }

    public void onMissfire(View view) {
        sounds.play(sound_missfire, 1.0f, 1.0f, 1, 0, 1);
        blood_image.setVisibility(View.INVISIBLE);
    }

    public void onDumb(View view) {
        sounds.play(soung_dumb, 1.0f, 1.0f, 1, 0, 1);
        blood_image.setVisibility(View.INVISIBLE);
    }
}
