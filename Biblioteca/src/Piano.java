import java.util.List;
import java.util.ArrayList;

public class Piano {

    private Scaffale [] scaffali;
    public Scaffale [] getScaffali(){
        return scaffali;
    }
    private char[] alfabeto = "ABCDEFGHILMN".toCharArray();

    public Piano(int numeroScaffali){
        scaffali = new Scaffale[numeroScaffali];
    }



    public void aggiungiLibro(Libro libro, String scaffale) {
// il carattere c è l'i-esimo del mio array alfabeto
        char c = scaffale.charAt(0);
        int i =0;

        for (;i < alfabeto.length; i++){

            if (alfabeto[i] ==c){
                break;
            }
        }
        if(scaffali[i] == null){
            scaffali[i] =new Scaffale();
        }
        scaffali[i].aggiungiLibro(libro);

    }




}
