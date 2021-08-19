package com.example.me_net;

public class data
{
    private String capt, usuario;
    private int imgs;

    public data()
    {

    }

    public data(String capt, String usuario, int imgs) {
        this.capt = capt;
        this.usuario = usuario;
        this.imgs = imgs;
    }

    public String getCapt() {
        return capt;
    }

    public void setCapt(String capt) {
        this.capt = capt;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getImgs() {
        return imgs;
    }

    public void setImgs(int imgs) {
        this.imgs = imgs;
    }


}
