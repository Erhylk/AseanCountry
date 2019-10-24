package com.example.aseancountry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] bendera, namaNegara, laguKebangsaan, bahasaResmi, mataUang, ibuKota, kodeIso,  deskripsi ;
    RecyclerView listNegara;
    private ArrayList<Country> countries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadData();
        listNegara =findViewById(R.id.list_negara);
        addItem();
        listNegara.setLayoutManager(new LinearLayoutManager(this));
        CountryAdapter adapter = new CountryAdapter(getApplicationContext());
        adapter.setCountries(countries);
        listNegara.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tentang, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.tentang){
            Intent intent = new Intent(this,AboutActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void addItem() {
        countries = new ArrayList<>();
        for (int i = 0; i < namaNegara.length; i++){
            Country country = new Country();
            country.setNamaNegara(namaNegara[i]);
            country.setBahasaResmi(bahasaResmi[i]);
            country.setBendera(bendera[i]);
            country.setLaguKebangsaan(laguKebangsaan[i]);
            country.setDeskripsi(deskripsi[i]);
            country.setMataUang(mataUang[i]);
            country.setIbuKota(ibuKota[i]);
            country.setKodeIso(kodeIso[i]);
            countries.add(country);
        }
    }

    private void loadData() {
        bendera = getResources().getStringArray(R.array.bendera);
        namaNegara = getResources().getStringArray(R.array.nama_negara);
        laguKebangsaan = getResources().getStringArray(R.array.lagu_kebangsaan);
        bahasaResmi = getResources().getStringArray(R.array.bahasa_resmi);
        mataUang = getResources().getStringArray(R.array.mata_uang);
        ibuKota = getResources().getStringArray(R.array.ibu_kota);
        kodeIso = getResources().getStringArray(R.array.kode_iso);
        deskripsi = getResources().getStringArray(R.array.deskripsi);
    }
}
