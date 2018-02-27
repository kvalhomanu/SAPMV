
package Serial;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

 
public class Arquivo extends IOException {

    public void lerArquivo(HUD_relatorio hud){
      
    hud.textin("\nConteúdo do arquivo texto:\n");
    try {
      FileReader arq = new FileReader("C:/Users/kvalh/Desktop/estacionamento.txt");
      BufferedReader lerArq = new BufferedReader(arq);
 
      String linha = lerArq.readLine();
      while (linha != null) {
        hud.textin(linha);
 
        linha = lerArq.readLine(); 
      }
 
      arq.close();
    } catch (IOException e) {
        hud.textin(e.getMessage());
    }
 
    System.out.println();
  }

    public void lerArquivo(HUD_Quant hud){
        
    hud.textin("\nConteúdo do arquivo texto:\n");
    try {
      FileReader arq = new FileReader("C:/Users/kvalh/Desktop/quantitativo.txt");
      BufferedReader lerArq = new BufferedReader(arq);
 
      String linha = lerArq.readLine();
      while (linha != null) {
        hud.textin(linha);
 
        linha = lerArq.readLine(); 
      }
 
      arq.close();
    } catch (IOException e) {
        hud.textin(e.getMessage());
    }
 
    System.out.println();
  }

    public static void escritor(String msg, FileWriter AT) throws IOException {
     
        BufferedWriter buffWrite = new BufferedWriter(AT); {
            String linha = "";
            linha = msg;
            buffWrite.append(linha + "\n");
        }

    }
}
