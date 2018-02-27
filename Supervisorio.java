package Serial;

public class Supervisorio {

    public static void main(String[] args) throws InterruptedException {
       SerialRxTx serial = new SerialRxTx();
       Vaga_A vaga_A = new Vaga_A();
       Vaga_B vaga_B = new Vaga_B();
       Sistema_interno sistema = new Sistema_interno();
       
       new HUD().setVisible(true);
       
        if(serial.iniciaSerial()){
            String info;
            String infoAnt = "";
            info = serial.getProtocolo().getVaga();
            serial.getProtocolo().getEstado();
            infoAnt = info;

            while("0".equals(serial.getProtocolo().getVaga()) == false){
                info = serial.getProtocolo().getVaga();
        
                if(info != infoAnt){
                    
                    if(info.equals("A")){
                        vaga_A.informa(serial.getProtocolo().getEstado());
                        infoAnt = info;
                    }
                    if(info.equals("B")){
                        vaga_B.informa(serial.getProtocolo().getEstado());
                        infoAnt = info;
                    }
                }
                Thread.sleep(500);
            }
        try {
            serial.close();
        } catch (Exception e){
            System.out.println("Erro ao liberar porta " + serial.getSerialportname());
            }
        
        }
    
        }
    }    

