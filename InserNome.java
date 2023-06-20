import java.io.*;
import java.util.*;

public class InserNome{
    public static int contL(File arq) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(arq));
        String linha;
        int contL = 0;
        while((linha = br.readLine()) != null){
            contL++;
        }
        br.close();
        return contL;
    }
    public static void main(String[] args) throws IOException{
        if(args.length == 0){
            System.out.println("Falta de argumentos. Insira o nome do arquivo!");
            return;
        }

        File arq = new File(args[0]);

        if(!arq.exists()){
            System.out.println("O arquivo informado não existe. Por favor, informe um arquivo que já existe!");
            return;
        }

        Scanner sc = new Scanner(System.in);

        System.out.println("Informe um nome: ");
        String nome = sc.nextLine();
        System.out.println();

        int qntdL = contL(arq);

        BufferedReader br = new BufferedReader(new FileReader(arq));
        String vetDados[] = new String[qntdL+1];
        String linha;

        linha = br.readLine();
        for(int i = 0;linha != null; i++){
            vetDados[i] = linha;
            linha = br.readLine();
        }
        vetDados[vetDados.length-1] = nome;

        Arrays.sort(vetDados);

        System.out.println("Forma de dados reorganizados no arquivo:");
        for (String x : vetDados) {
            System.out.println(x+"\n");
        }

        FileWriter fw = new FileWriter(arq);

        String dados = "";
        for(int i = 0; i <= qntdL; i++){
        dados+=vetDados[i]+"\n";
        }
        fw.write(dados);
        fw.close();
    }
}