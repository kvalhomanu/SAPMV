
package Serial;

public class Imprimir {
    String estado_a;
    String estado_b;
    
    HUD hud = new HUD();
        
    public void imprime(String vaga, String estado){
        if(vaga.equals("A")){
            if("1".equals(estado_a = estado)){
                this.estado_a = "ocupado";
            }else{
                this.estado_a = " livre ";
                    }
        if(vaga.equals("B")){
            if("1".equals(estado_b = estado)){
                this.estado_b = "ocupado";
            }else{
                this.estado_b = " livre ";
                    }
        }
        hud.textin("Vaga A  -----  Vaga B");
        hud.textin(estado_a + " ----- " + estado_b );
        System.out.println("Vaga A  -----  Vaga B");
        System.out.println(estado_a + " ----- " + estado_b );
        System.out.println(" ");
        
        }
    }
}