import java.io.*;

public class RmPlvr {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println("Argumentos insuficientes. Por favor, insira o nome de um arquivo e a palavra a ser procurada!");
            return;
        }
        
        File arq = new File(args[0]);
        if (!arq.exists()) {
            System.out.println("O arquivo pesquisado não existe. Por favor, pesquise um arquivo existente!");
            return;
        }

        FileReader fr = new FileReader(args[0]);
        BufferedReader br = new BufferedReader(fr);
        String linha;
        String text = "";
        boolean busca = false;
        boolean achado = false;

        while((linha = br.readLine()) != null){
            int initPl = -1;
            int fimPl = -1;
            boolean inWord = false;
            String linhaAt = "";

            for (int i = 0; i < linha.length(); i++) {
                if(achado){
                    break;
                }
                char c = linha.charAt(i);

                if(!inWord && c != ' '){
                    inWord = true;
                    initPl = i;
                } else if(inWord && (c == ' ' || i == linha.length()-1)){
                    inWord = false;
                    fimPl = i;

                    if(linha.substring(initPl, fimPl).equals(args[1])){
                        achado = true;
                        busca = true;
                    }
                }
            }
            if(achado){
                    linhaAt+=linha.substring(fimPl+1);
            }
            else {
                linhaAt=linha;
            }
            text+=linhaAt+"\n";
            achado = false;
        }
        System.out.println(text);
        br.close();
        if(busca){
            FileWriter fw = new FileWriter(arq);
            fw.write(text);
            fw.close();
        }
        else
            System.out.println("A palavra procurada não existe no arquivo escolhido!");
    }
}