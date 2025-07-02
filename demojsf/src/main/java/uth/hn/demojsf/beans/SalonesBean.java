package uth.hn.demojsf.beans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("salones")
@SessionScoped
public class SalonesBean implements Serializable {
    private List<String> salones;

    public SalonesBean() {
        this.salones = new ArrayList<String>();
    }

    public void agregarSalon(String salon) {
        this.salones.add(salon);
    }

    public List<String> getSalones() {
        return salones;
    }

    public void setSalones(List<String> salones) {
        this.salones = salones;
    }
}
