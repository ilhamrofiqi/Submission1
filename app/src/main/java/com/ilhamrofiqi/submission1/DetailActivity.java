package com.ilhamrofiqi.submission1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_PERSON = "extra_person";
    TextView tvnama, tvdesk, tvdirec, tvrilis, tvdurasi;
    ImageView imgposter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvnama = findViewById(R.id.tv_nama);
        tvdesk = findViewById(R.id.tv_desk);
        tvdirec = findViewById(R.id.tv_direc);
        tvrilis = findViewById(R.id.tv_rilis);
        tvdurasi = findViewById(R.id.tv_durasi);
        imgposter = findViewById(R.id.img_poster);

        Film film = getIntent().getParcelableExtra(EXTRA_PERSON);
        int img = film.getPoster();
        String nama = film.getName();
        String direc = film.getDirector();
        String rilis = film.getRelease();
        String durasi = film.getDurasi();
        String desk = film.getDescription();

        imgposter.setImageResource(img);
        tvnama.setText(nama);
        tvdirec.setText(direc);
        tvrilis.setText(rilis);
        tvdurasi.setText(durasi);
        tvdesk.setText(desk);

    }
}
