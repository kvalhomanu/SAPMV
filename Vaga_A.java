
package Serial;

public class Vaga_A{
    int hora_o, hora_l;
    int min_o, min_l;
    
    Sistema_interno horario = new Sistema_interno();
    
    public void informa(String info) {
 
                if("0".equals(info)){
                    System.out.println("Vaga A livre");
                    hora_l = horario.Horario_H();
                    min_l = horario.Horario_M();
                    //System.out.println("Hora " + hora_o + ":" + min_o);
                }
                if("1".equals(info)){
                    System.out.println("Vaga A ocupada");
                    hora_o = horario.Horario_H();
                    min_o = horario.Horario_M();
                    System.out.println("Hora " + hora_o + ":" + min_o + ":" + horario.Horario_S());
                } 
                if("N".equals(info)){
                    System.out.println("Novo carro na vaga A");
                }
    }


    public void tarifa(int h_o, int m_o, int h_l, int m_l){
        int horas, minutos;
        horas = h_l - h_o;
        minutos = m_l - m_o;
        
        System.out.println(horas + " " + minutos);
 
    }
}