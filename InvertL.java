import java.io.*;

public class InvertL {
    public static void main(String[] args) throws IOException{
        File arq = new File(args[0]);
        FileReader fr = new FileReader(arq);
        BufferedReader br = new BufferedReader(fr);


        String text = "";
        String linha;
        while((linha = br.readLine())!= null){
            text+=linha+"\n";
        }

        String vetText[] = text.split("\n");

        FileWriter fw = new FileWriter(arq);

        fw.write("");

        fw.close();

        FileWriter fw2 = new FileWriter(arq, true);

        for (int i = vetText.length-1; i >= 0; i--) {
            System.out.println(vetText[i]);
            fw2.write(vetText[i]+"\n");
        }
        fw2.close();
        fr.close();
    }
}