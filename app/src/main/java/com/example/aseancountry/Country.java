package com.example.aseancountry;

import android.os.Parcel;
import android.os.Parcelable;

class Country implements Parcelable {
    private String bendera, namaNegara, laguKebangsaan, bahasaResmi, mataUang, ibuKota, kodeIso, deskripsi;

    public String getBendera() {
        return bendera;
    }

    public void setBendera(String bendera) {
        this.bendera = bendera;
    }

    public String getNamaNegara() {
        return namaNegara;
    }

    public void setNamaNegara(String namaNegara) {
        this.namaNegara = namaNegara;
    }

    public String getLaguKebangsaan() {
        return laguKebangsaan;
    }

    public void setLaguKebangsaan(String laguKebangsaan) {
        this.laguKebangsaan = laguKebangsaan;
    }

    public String getBahasaResmi() {
        return bahasaResmi;
    }

    public void setBahasaResmi(String bahasaResmi) {
        this.bahasaResmi = bahasaResmi;
    }

    public String getMataUang() { return mataUang; }

    public void setMataUang(String mataUang) { this.mataUang = mataUang; }

    public String getIbuKota() { return ibuKota; }

    public void setIbuKota(String ibuKota) { this.ibuKota = ibuKota; }

    public String getKodeIso() { return kodeIso; }

    public void setKodeIso(String kodeIso) { this.kodeIso = kodeIso; }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.bendera);
        dest.writeString(this.namaNegara);
        dest.writeString(this.laguKebangsaan);
        dest.writeString(this.bahasaResmi);
        dest.writeString(this.mataUang);
        dest.writeString(this.ibuKota);
        dest.writeString(this.kodeIso);
        dest.writeString(this.deskripsi);
    }

    public Country() {
    }

    protected Country(Parcel in) {
        this.bendera = in.readString();
        this.namaNegara = in.readString();
        this.laguKebangsaan = in.readString();
        this.bahasaResmi = in.readString();
        this.mataUang = in.readString();
        this.ibuKota = in.readString();
        this.kodeIso = in.readString();
        this.deskripsi = in.readString();
    }

    public static final Parcelable.Creator<Country> CREATOR = new Parcelable.Creator<Country>() {
        @Override
        public Country createFromParcel(Parcel source) {
            return new Country(source);
        }

        @Override
        public Country[] newArray(int size) {
            return new Country[size];
        }
    };
}

