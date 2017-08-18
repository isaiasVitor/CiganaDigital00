package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Usuario {

    public static String nome;
    public static String dataNascimento;
    public static Integer dataEspiritual;
    public static Boolean running;
    public static Boolean dateRunning;
    
    public Usuario(String nome) {
    Usuario.nome = nome;
    Usuario.running = true;
    Usuario.dateRunning = true;
    }

    public boolean isDateRunning() {
        return dateRunning;
    }

    public void setDateRunning(Boolean dateRunning) {
        Usuario.dateRunning = dateRunning;
    }
    
    public boolean isRunning() {
        return running;
    }

    public void setRunning(Boolean running) {
        Usuario.running = running;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        Usuario.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        Usuario.nome = nome;
    }

    public Integer getDataEspiritual() {
        return dataEspiritual;
    }

    public void setDataEspiritual(Integer dataEspiritual) {
        Usuario.dataEspiritual = dataEspiritual;
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
   public static String encontraSigno(int dia, int mes){   
        if((dia >= 20 && mes == 3) || ( dia <=20 && mes == 4)){
            return "Aries";
        }else if((dia >=21 && mes == 4) || (dia <= 20 && mes == 5)){
                    return "Touro";
            }else if((dia >= 21 && mes == 5) || (dia <=20 && mes ==6)){
                        return "Gemeos" ;
                    }else if((dia >= 21 && mes == 6) || (dia <=21 && mes ==7)){
                              return "Cancer";
                        }else if((dia >= 22 && mes == 7) || (dia <=22 && mes ==8)){
                                    return "Leao";
                            }else if((dia >= 23 && mes == 8) || (dia <=22 && mes ==9)){
                                        return "Virgem";
                                }else if((dia >= 23  && mes == 9) || (dia <= 22 && mes == 10)){
                                            return "Libra";
                                    }else if((dia >= 23 && mes == 10) || (dia <= 21 && mes ==11)){
                                                System.out.println("Escorpião");
                                        }else if((dia >= 22 && mes == 11) || (dia <= 21 && mes == 12)){
                                                     return "Sagitario";
                                            }else if((dia >= 22 && mes == 12) || (dia <= 21 && mes == 1)){
                                                         return "Capricornio";
                                                }else if((dia >= 21 && mes == 1) || (dia <= 18 && mes == 2)){
                                                             return "Aquario";
                                                    }else if((dia >= 19 && mes == 2) || (dia <= 19 && mes == 3)){
                                                                 return "Peixes";
                                                    }
        return null;
        
    }
   
  
}
