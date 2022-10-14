package edu.uoc.cardview.modelos;

public class CuentosRV {

    private int Image;

    public CuentosRV(int image, String title, int id) {
        Image = image;
        this.title = title;
        Id = id;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public CuentosRV(int image, String title) {
        Image = image;
        this.title = title;
    }

    public CuentosRV () {

    }
    private String title;
    private int Id;

}
