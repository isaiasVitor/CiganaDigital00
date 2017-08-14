package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Usuario {

    private String nome;
    private String dataNascimento;
    private Integer dataEspiritual;
    private Boolean running;
    private Boolean dateRunning;
    
    public Usuario(String nome, Boolean running) {
        this.nome = nome;
        this.running = running;
        this.dateRunning = true;
    }

    public boolean isDateRunning() {
        return dateRunning;
    }

    public void setDateRunning(Boolean dateRunning) {
        this.dateRunning = dateRunning;
    }
    
    public boolean isRunning() {
        return running;
    }

    public void setRunning(Boolean running) {
        this.running = running;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getDataEspiritual() {
        return dataEspiritual;
    }

    public void setDataEspiritual(Integer dataEspiritual) {
        this.dataEspiritual = dataEspiritual;
    }

   public static Date stringToDate(String data1) {
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        f.setLenient(false);
        java.util.Date d1 = null;
        try {
            d1 = f.parse(data1);
        } catch (ParseException e) {}
        return d1;
    }
   
  
}
