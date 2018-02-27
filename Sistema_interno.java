package Serial;

import java.util.Date;
import java.text.SimpleDateFormat;
/*
Codigos para obtenção de informações por SimpleDateFormat:
y ano
M mes
dd dia do mes
EEE dia da semana abreviado em portugues
EEEE dia da semana completo em portugues
D dia
H hora do dia(0/24)
h Hora da manha ou da tarde(0/12)
m minuto
s segundo
S milisegundo
 */

public class Sistema_interno {
    Date momento = new Date();

    SimpleDateFormat minutos = new SimpleDateFormat("m");
    SimpleDateFormat hora = new SimpleDateFormat("H");
    SimpleDateFormat segundos = new SimpleDateFormat("s");

    String Minuto = minutos.format(momento);
    String Hora = hora.format(momento);
    String Segundo = segundos.format(momento);

    public int Horario_H(){
        return Integer.parseInt(Hora);
    }
    public int Horario_M(){
        return Integer.parseInt(Minuto);
    }
   public int Horario_S(){
       return Integer.parseInt(Segundo);
   }
       
}                