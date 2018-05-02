package sample.Classes;

import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

public class Validacion {
    private SimpleStringProperty cadena;
    private SimpleStringProperty validity;
    private SimpleStringProperty description;

    public Validacion(String cadena, Boolean validity, ArrayList<String> estadosVisitados){
        this.cadena = new SimpleStringProperty(cadena);
        this.validity = new SimpleStringProperty(validity ? "Si." : "No.");
        this.description = new SimpleStringProperty(estadosVisitados.toString());
    }

    public SimpleStringProperty cadenaProperty() {
        return cadena;
    }

    public SimpleStringProperty validityProperty() {
        return validity;
    }

    public SimpleStringProperty descriptionProperty() {
        return description;
    }

    public String getCadena() {
        return cadena.get();
    }

    public String getValidity() {
        return validity.get();
    }

    public String getDescription() {
        return description.get();
    }

    public void setCadena(String cadena){
        this.cadena.set(cadena);
    }

    public void setValidity(Boolean validity){
        this.validity.set(validity ? "Si." : "No.");
    }

    public void setDescription(ArrayList<String> estadosVisitados){
        this.description.set(estadosVisitados.toString());
    }
}
