
package Serial;

public class Vaga_B{
    int hora_o, hora_l;
    int min_o, min_l;
    
    Sistema_interno horario = new Sistema_interno();
    
    public void informa(String info) {
 
                if("0".equals(info)){
                    System.out.println("Vaga B livre");
                    hora_l = horario.Horario_H();
                    min_l = horario.Horario_M();
                    //System.out.println("Hora " + hora_l + ":" + min_l);
                    //tarifa(hora_o, min_o, hora_l, min_l);
                }
                if("1".equals(info)){
                    System.out.println("Vaga B ocupada");
                    hora_o = horario.Horario_H();
                    min_o = horario.Horario_M();
                    System.out.println("Hora " + hora_o + ":" + min_o + ":" + horario.Horario_S());
                }
                 if("N".equals(info)){
                    //System.out.println("Recebido: " + serial.getProtocolo().getLeituraComando());
                    System.out.println("Novo carro na vaga B");
                }
    }


    public void tarifa(int h_o, int m_o, int h_l, int m_l){
        int horas, minutos;
        horas = h_l - h_o;
        minutos = m_l - m_o;
        
        System.out.println(horas + " " + minutos);
 
    }
}