package com.example.aseancountry;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {
    private Context context;
    private ArrayList<Country> countries;

    public void setCountries(ArrayList<Country> countries) {
        this.countries = countries;
    }

    public CountryAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_negara, parent,false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        holder.bind(countries.get(position));

    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public class CountryViewHolder extends RecyclerView.ViewHolder {
        private ImageView bendera;
        private TextView namaNegara ; //laguKebangsaan;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            bendera = itemView.findViewById(R.id.bendera);
            namaNegara = itemView.findViewById(R.id.nama_negara);
//            laguKebangsaan = itemView.findViewById(R.id.lagu_kebangsaan);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("country", countries.get(getAdapterPosition()));
                    context.startActivity(intent);
                }
            });
        }

        public void bind(Country country) {
            Glide.with(context)
                    .load(country.getBendera())
                    .apply(new RequestOptions())
                    .into(bendera);
            namaNegara.setText(country.getNamaNegara());
//            laguKebangsaan.setText(country.getLaguKebangsaan());
        }
    }
}
