package Serial;

import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

import java.io.BufferedReader;
import java.io.OutputStream;

import java.util.Enumeration;
import gnu.io.CommPortIdentifier;
import java.io.InputStreamReader;

public class SerialRxTx implements SerialPortEventListener{
    SerialPort serialPort = null;    
    
    private Protocolo protocolo = new Protocolo();
    private String appname;
    
    private BufferedReader input; //objeto para leitura na serial
    private OutputStream output; //objeto para escrita na serial
    
    private static final int TIME_OUT = 1000; // tempo de espera da comunicação serial
    private static int DATA_RATE = 9600; // velocidade da comunicação serial
    
    private String serialportname = "COM10";

    //------------------------ metodos ----------------------
    // encontra, abre e aplica parametros na porta serial
    public boolean iniciaSerial(){
        try {
            // obtem portas seriais do sistema
            CommPortIdentifier portid = null; // identificador de porta serial
            Enumeration portEnum = CommPortIdentifier.getPortIdentifiers(); // Recebe portas seriais em ordem
            
            while(portid == null && portEnum.hasMoreElements()){
                CommPortIdentifier porta_atual = (CommPortIdentifier) portEnum.nextElement(); // identifica a porta atual
                
                if (porta_atual.getName().equals(serialportname) || porta_atual.getName().startsWith(serialportname)){      // cai no if se for a serial selecionada em serialportname
                    serialPort = (SerialPort) porta_atual.open(appname, TIME_OUT); // abre conexão com a porta no sistema
                    portid = porta_atual;
                    System.out.println("Conectado a " + portid.getName());
                    break;
                }
                
            }
            
            if (portid == null ||  serialPort == null){     //Falhou em conectar em alguma porta
                return false;
            }
            
            //dando parametros para porta serial
            serialPort.setSerialPortParams(DATA_RATE,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);   //Velocidade, 8 bits de dados, 
            
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);    //notifica quando receber dados
            
            try {
                Thread.sleep(1000);  //pausa antes de iniciar comunicação
            } catch(InterruptedException e){
                e.printStackTrace(); //imprime a pilha de exceção(erros)
                System.out.println("Erro");

            }
            // fim do try, se chegar até aqui, a comunicação foi estabelecida
            return true;
            
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Erro");
        }
        //nao funcionou
        return false;
    }
    
    //Envia dados pela serial
    public void sendData(String data){
        try{
            output = serialPort.getOutputStream();  //aloca o output para o fluxo de saída da porta serial
            output.write(data.getBytes());
            
        } catch (Exception e) {
            System.err.println(e.toString()); // impressão de erro
            System.out.println("Impossibilidade de envio");
        }
    }
    
    //fecha a porta serial para que possa ser usada pelo sistema
    public synchronized void close(){
        if (serialPort != null){
            serialPort.removeEventListener();
            serialPort.close();            
        }
    }
    
    //recebe dados pela serial
    public void serialEvent(SerialPortEvent spe) {
        try {
            switch(spe.getEventType()){
                case SerialPortEvent.DATA_AVAILABLE:
                    if(input == null){
                        input = new BufferedReader(
                                new InputStreamReader(
                                        serialPort.getInputStream()));
            //transmite o fluxo de entrada da porta serial para o inputstreamreader q é usado no bufferedreader
                    }
                    
                    //serve para verificar se o buffer esta liberado
                    if (input.ready()){
                        String inputLine = input.readLine(); // comando recebido pelo arduino
                        protocolo.setLeituraComando(inputLine);
                        //System.out.println("Recebido: " + protocolo.getLeituraComando());
                    }
                    break;
                    
                default:
                    break;
                    
            }   // fim do switch
            
        } catch (Exception e){
            e.printStackTrace();
        }
        
    }
    
    //---------getters e setters ---------------------------
    
    public Protocolo getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(Protocolo protocolo) {
        this.protocolo = protocolo;
    }

    public static int getDATA_RATE() {
        return DATA_RATE;
    }

    public static void setDATA_RATE(int DATA_RATE) {
        SerialRxTx.DATA_RATE = DATA_RATE;
    }

    public String getSerialportname() {
        return serialportname;
    }

    public void setSerialportname(String serialportname) {
        this.serialportname = serialportname;
    }
    
    
    
}
