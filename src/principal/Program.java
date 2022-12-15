import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> votos = new HashMap<>(); 

        System.out.print("Enter file full path: ");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            
            String urna = br.readLine();
            while (urna != null ) {
                String[] informacao = urna.split(",");
                String nome = informacao[0];
                int contagem = Integer.parseInt(informacao[1]);

                if (votos.containsKey(nome)) {
                    int votosAtuais = votos.get(nome) + contagem;
                    votos.put(nome, votosAtuais);
                }
                else {
                    votos.put(nome, contagem);
                }

                urna = br.readLine();

            }

            for (String nome : votos.keySet()) {
                System.out.println(nome + ": " + votos.get(nome));
            }


        } catch (IOException e) {
            e.getMessage();
        }



    }

}