package com.example.appnovel34;

public class Model {
    String nik, name, phone, gender, genre, age, keterangan, is_valid;

    public String getIs_valid() {
        return is_valid;
    }

    public void setIs_valid(String is_valid) {
        this.is_valid = is_valid;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Model(String nik, String name, String phone, String gender, String genre, String age, String keterangan, String is_valid){
        this.nik = nik;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.genre = genre;
        this.age = age;
        this.keterangan = keterangan;
        this.is_valid = is_valid;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return name;
    }

    public void setNama(String name) {
        this.name = name;
    }

    public String getTelepon() {
        return phone;
    }

    public void setPhone(String phone) { this.phone = phone; }

    public String getJenis_kelamin() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getKondisi_kesehatan (){ return genre; }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPersentase_kondisi() {
        return age;
    }

    public void setAge (String age) {
        this.age = age;
    }
}
