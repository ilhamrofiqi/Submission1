package com.ilhamrofiqi.submission1;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.security.Key;
import java.util.ArrayList;

import static android.provider.Contacts.SettingsColumns.KEY;

public class MainActivity extends AppCompatActivity {
    private String[] dataName;
    private String[] dataDirec;
    private String[] dataRilis;
    private String[] dataDurasi;
    private String[] dataDescription;
    private TypedArray dataPoster;
    private FilmAdapter adapter;
    private ArrayList<Film> films;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new FilmAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Film film = new Film();
                film.setPoster(dataPoster.getResourceId(position, -1));
                film.setName(dataName[position]);
                film.setDirector(dataDirec[position]);
                film.setRelease(dataRilis[position]);
                film.setDurasi(dataDurasi[position]);
                film.setDescription(dataDescription[position]);

                Intent moveObjectIntent = new Intent(MainActivity.this, DetailActivity.class);
                moveObjectIntent.putExtra(DetailActivity.EXTRA_PERSON, film);
                startActivity(moveObjectIntent);
            }
        });
    }

    private void addItem() {
        films = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            Film film = new Film();
            film.setPoster(dataPoster.getResourceId(i, -1));
            film.setName(dataName[i]);
            film.setDirector(dataDirec[i]);
            film.setRelease(dataRilis[i]);
            film.setDurasi(dataDurasi[i]);
            film.setDescription(dataDescription[i]);
            films.add(film);
        }
        adapter.setFilms(films);
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name);
        dataDirec = getResources().getStringArray(R.array.data_direc);
        dataRilis = getResources().getStringArray(R.array.data_rilis);
        dataDurasi = getResources().getStringArray(R.array.data_durasi);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPoster = getResources().obtainTypedArray(R.array.data_poster);
    }
}
