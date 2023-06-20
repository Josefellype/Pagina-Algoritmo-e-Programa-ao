import java.io.*;

public class ProcPlvr {
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
        boolean busca = false;

        while((linha = br.readLine()) != null){
            int initPl = -1;
            int fimPl = -1;
            boolean inWord = false;

            for (int i = 0; i < linha.length(); i++) {
                char c = linha.charAt(i);

                if(!inWord && c != ' '){
                    inWord = true;
                    initPl = i;
                } else if(inWord && (c == ' ' || i == linha.length()-1)){
                    inWord = false;
                    fimPl = i;

                    String plvr = linha.substring(initPl, fimPl);
                    if(plvr.equalsIgnoreCase(args[1])){
                        System.out.println(linha);
                        busca = true;
                        break;
                    }
                }
            }
        br.close();
        if(!busca)
            System.out.println("A palavra procurada não existe no arquivo escolhido!");
        }
    }
}