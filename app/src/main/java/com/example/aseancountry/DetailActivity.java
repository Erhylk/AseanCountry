package com.example.aseancountry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        Country country = intent.getParcelableExtra("country");
        showDetail(country);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(country.getNamaNegara());
    }

    private void showDetail(Country country) {
        ImageView bendera = findViewById(R.id.bendera);
        TextView nama_negara = findViewById(R.id.nama_ngr);
        TextView bahasa_resmi = findViewById(R.id.bhs_resmi);
        TextView lagu_kebangsaan = findViewById((R.id.lagu_bgs));
        TextView mata_uang = findViewById(R.id.mata_uang);
        TextView ibu_kota = findViewById(R.id.ibu_kota);
        TextView kode_iso = findViewById(R.id.kode_iso);
        TextView deskripsi_negara = findViewById(R.id.deskripsi_ngr);
        Glide.with(getApplicationContext())
                .load(country.getBendera())
                .apply(new RequestOptions())
                .into(bendera);
        nama_negara.setText(country.getNamaNegara());
        bahasa_resmi.setText(country.getBahasaResmi());
        lagu_kebangsaan.setText(country.getLaguKebangsaan());
        mata_uang.setText(country.getMataUang());
        ibu_kota.setText(country.getIbuKota());
        kode_iso.setText(country.getKodeIso());
        deskripsi_negara.setText(country.getDeskripsi());
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            this.finish();
        return super.onOptionsItemSelected(item);
    }
}
