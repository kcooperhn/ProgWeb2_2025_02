package uth.hn.demojsf.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import org.primefaces.PrimeFaces;
import uth.hn.demojsf.abstracciones.Reserva;

@Named("ReservacionesBean")

@SessionScoped
public class ReservacionesBean implements Serializable {
    private List<Reserva> reservas;
    private Reserva reserva;

    public ReservacionesBean() {
        this.reservas = new ArrayList<>();
        this.reserva = new Reserva();
    }

    public void reservar() {
        //TODO: VALIDAR QUE TODOS LOS DATOS VENGAN
        //TODO: VALIDAR QUE NO ESTE RESERVADO ESE SALON
        this.reservas.add(this.reserva);
        mostrarMensaje("Reserva creada exitosamente", FacesMessage.SEVERITY_INFO);
        this.reserva = new Reserva();
    }

    public void cancelar(Reserva r){

    }

    private void mostrarMensaje(String mensaje, FacesMessage.Severity tipo) {
        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(tipo, mensaje, null));
        FacesMessage message = new FacesMessage(tipo, mensaje, null);
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}
