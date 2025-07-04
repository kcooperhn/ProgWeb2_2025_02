package uth.hn.demojsf.beans;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import org.primefaces.PrimeFaces;
import org.primefaces.model.DialogFrameworkOptions;
import uth.hn.demojsf.abstracciones.Reserva;

@Named("ReservacionesBean")
@SessionScoped
public class ReservacionesBean implements Serializable {
    private List<Reserva> reservas;
    private Reserva reserva;
    private String mensaje;
    private LocalDateTime minDateTime;
    private LocalDateTime minEndDateTime;

    public ReservacionesBean() {
        this.reservas = new ArrayList<>();
        this.reserva = new Reserva();
        this.mensaje = "";
        this.minDateTime = LocalDateTime.now();
        this.minEndDateTime = LocalDateTime.now().plusHours(1);
    }

    public void reservar() {
        //TODO: VALIDAR QUE TODOS LOS DATOS VENGAN
        //TODO: VALIDAR QUE NO ESTE RESERVADO ESE SALON
        this.reservas.add(this.reserva);
        this.reserva = new Reserva();
        mostrarMensaje("Reserva creada exitosamente", FacesMessage.SEVERITY_INFO);
    }

    public void cancelar(Reserva r){
        this.reservas.remove(r);
        mostrarMensaje("Reserva cancelada", FacesMessage.SEVERITY_INFO);
    }

    private void mostrarMensaje(String mensaje, FacesMessage.Severity tipo) {
        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(tipo, mensaje, null));
        FacesMessage message = new FacesMessage(tipo, mensaje, null);
        this.mensaje = mensaje;
        PrimeFaces.current().dialog().showMessageDynamic(message);
        //generateDialog();
    }

    private void generateDialog(){
        DialogFrameworkOptions options = DialogFrameworkOptions.builder()
                .modal(true)
                .fitViewport(true)
                .responsive(true)
                .width("900px")
                .contentWidth("100%")
                .resizeObserver(true)
                .resizeObserverCenter(true)
                .resizable(false)
                .styleClass("max-w-screen")
                .iframeStyleClass("max-w-screen")
                .build();

        PrimeFaces.current().dialog().openDynamic("mensajeReservas", options, null);
    }

    public void closeDialog() {
        //pass back to level 2
        PrimeFaces.current().dialog().closeDynamic("");
    }

    public void onStartDateChange(){
        this.minEndDateTime = this.reserva.getFinicio().plusHours(1);
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

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getMinDateTime() {
        return minDateTime;
    }

    public void setMinDateTime(LocalDateTime minDateTime) {
        this.minDateTime = minDateTime;
    }

    public LocalDateTime getMinEndDateTime() {
        return minEndDateTime;
    }

    public void setMinEndDateTime(LocalDateTime minEndDateTime) {
        this.minEndDateTime = minEndDateTime;
    }
}
