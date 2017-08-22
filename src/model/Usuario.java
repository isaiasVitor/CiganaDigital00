package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.objects.NativeString.charAt;

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
   
     public static boolean validaData(String data1){
      String nomeMes = String.valueOf(pegaMes(data1));
        switch (nomeMes) {
            case "1":
            case "01":
                nomeMes = "Janeiro";
                break;
            case "02":
            case "2":
                nomeMes = "Fevereiro";
                break;
            case "03":
            case "3":
                nomeMes = "Março"; 
                break;
            case "4":
            case "04":
                nomeMes = "Abril";
                break;
            case "05":
            case "5":
                nomeMes = "Maio";
                break;
            case "6":
            case "06":
                nomeMes = "Junho";
                break;
            case "07":
            case "7":
                nomeMes = "Julho"; 
                break;
            case "08":
            case "8": 
                nomeMes = "Agosto"; 
                break;
            case "9":
            case "09":
                nomeMes = "Setembro";
                break;
            case "10":
                nomeMes = "Outubro"; 
                break;    
            case "11":
                nomeMes = "Novembro";
                break;
            default:
                break;
            case "12":
                nomeMes = "Dezembro"; 
                break;    
        }
       
        //valida dia ou mes 0
        if(pegaDia(data1)>0 || pegaMes(data1)> 0){
            // valida mes fevereiro (max 28 dias)
            if(pegaMes(data1)==2){
               if(pegaDia(data1)>29){
                   JOptionPane.showMessageDialog(null, nomeMes + " tem 28 dias (29 dias nos anos bissextos) ");
                   return false;
               }
            } 

            // valida meses com MAX 30 dias
            if(pegaMes(data1)== 4 ||pegaMes(data1)== 6 || pegaMes(data1)== 9 || pegaMes(data1)== 11){
                if(pegaDia(data1)>30){
                    JOptionPane.showMessageDialog(null, nomeMes + " Tem 30 dias");
                    return false;
                }
            }

            // valida meses com MAX 31 dias
            if(pegaMes(data1) == 1 || pegaMes(data1) == 3 || pegaMes(data1) == 5 || pegaMes(data1) == 7 || pegaMes(data1) == 8 || pegaMes(data1) == 10 || pegaMes(data1) == 12 ){
                if(pegaDia(data1) > 31){
                    JOptionPane.showMessageDialog(null, nomeMes + " Tem 31 dias");
                    return false;
                }
            }

            // valida 12 meses
            if (pegaMes(data1)>12){
                JOptionPane.showMessageDialog(null, "Um ano possui apenas 12 meses, digite novamente");
                return false;
            }
           
        }else {
            JOptionPane.showMessageDialog(null, "Dia ou Mes Invalido, tente novamente");
            return false;
        }
       return true;
   }
     
     public static int pegaDia(String datenasc){
       int dia = Integer.parseInt(charAt(datenasc, 0));
       dia = (dia * 10) + Integer.parseInt(charAt(datenasc, 1));
        
      return dia; 
   }
   
   public static int pegaMes(String datenasc){
       int mes = Integer.parseInt(charAt(datenasc, 3));
       mes = (mes * 10) + Integer.parseInt(charAt(datenasc, 4));
       
       return mes;
   }
  
}
