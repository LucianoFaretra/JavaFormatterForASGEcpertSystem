import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class Main {
    private static int LUNGHEZZA_RIGA=90;

    public static void main(String[] args) {

        System.out.println("Inserire Testo");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Stream<String> stream = in.lines().limit(1);

        String testo = stream.collect(joining());


        List<String> strings = Arrays.asList(testo.split(" "));
        String lineDaStampare = new String();
        String testoFinale = new String();
        testoFinale = testoFinale.concat("printout t \"********************************************************************************\" crlf);\n");
        String ultimaParola = new String();
        for(String s : strings){
            if(lineDaStampare.length() == 0){
                lineDaStampare = lineDaStampare.concat("printout t \"* ");
                if(ultimaParola.length() > 0){
                    lineDaStampare = lineDaStampare.concat(ultimaParola);
                }
            }
            if(s.length()+lineDaStampare.length() < LUNGHEZZA_RIGA){
                lineDaStampare = lineDaStampare.concat(" " + s);
            }else {
                ultimaParola = s;
                int spaziDaAggiungere = LUNGHEZZA_RIGA - lineDaStampare.length();
                for(int i = 0; spaziDaAggiungere > i; i++){
                    lineDaStampare = lineDaStampare.concat(" ");
                }
                lineDaStampare = lineDaStampare.concat(" *\" crlf);\n");
                testoFinale = testoFinale.concat(lineDaStampare) ;
                lineDaStampare = new String();
            }
        }
        int spaziDaAggiungere = LUNGHEZZA_RIGA - lineDaStampare.length();
        for(int i = 0; spaziDaAggiungere > i; i++){
            lineDaStampare = lineDaStampare.concat(" ");
        }
        lineDaStampare = lineDaStampare.concat(" *\" crlf);\n");
        testoFinale = testoFinale.concat(lineDaStampare) ;
        testoFinale = testoFinale.concat("printout t \"********************************************************************************\" crlf);\n");
        System.out.println(testoFinale);


    }
}
