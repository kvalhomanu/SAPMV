package Serial;

public class Protocolo {

    private String leitura;
    private String LeituraComando;
    private String vaga;
    private String estado;
    
    public void intepretaComando(){
        String aux[] = LeituraComando.split(":");
        
        if (aux.length == 2) {
            this.vaga = aux[0];
            this.estado = aux[1];
         }
    }

    public String getVaga() {
        //System.out.println(this.vaga);
        return this.vaga;
    }

    public String getEstado() {
        //System.out.println(this.estado);
        return estado;
    }

    public void setLeituraComando(String LeituraComando) {
        this.LeituraComando = LeituraComando;
        this.intepretaComando();
    }
    
   
}