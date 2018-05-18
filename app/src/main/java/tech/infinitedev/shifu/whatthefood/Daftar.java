package tech.infinitedev.shifu.whatthefood;

/**
 * Created by shifu on 6/8/17.
 */

class Daftar {
    private String name, display_harga, tipe;
    private int harga, thumbnail, jumlah;

    public Daftar() {
    }

    public Daftar(String name, int harga, int thumbnail, String display_harga, String tipe) {
        this.name = name;
        this.harga = harga;
        this.thumbnail = thumbnail;
        this.display_harga = display_harga;
        this.tipe = tipe;
    }


    public Daftar(String name, int harga, int thumbnail, int jumlah) {
        this.name = name;
        this.harga = harga;
        this.thumbnail = thumbnail;
        this.jumlah = jumlah;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDisplay_harga() {
        return display_harga;
    }

    public void setDisplay_harga(String display_harga) {
        this.display_harga = display_harga;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
}
