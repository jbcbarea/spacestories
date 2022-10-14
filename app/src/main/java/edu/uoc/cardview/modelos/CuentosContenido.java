package edu.uoc.cardview.modelos;

public class CuentosContenido {

    String title;
    int idimage;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIdimage() {
        return idimage;
    }

    public void setIdimage(int idimage) {
        this.idimage = idimage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getMoraleja() {
        return moraleja;
    }

    public void setMoraleja(String moraleja) {
        this.moraleja = moraleja;
    }

    public CuentosContenido(String title, int idimage, int id, String contenido, String moraleja) {
        this.title = title;
        this.idimage = idimage;
        this.id = id;
        this.contenido = contenido;
        this.moraleja = moraleja;
    }

    int id;
    String contenido;
    String moraleja;

    public CuentosContenido() {

    }

}
