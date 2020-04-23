import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[]args){

        Menu menu = new Menu();
        Biblioteca biblioteca = new Biblioteca(3);
        int azione =0;

        do {
            azione = menu.menu();
            interpreta(menu,biblioteca, azione);
        } while (azione != 0);

    }
    private static void interpreta(Menu menu, Biblioteca biblioteca, int azione)  {
        switch(azione) {
            /**/
            case 1:Libro libro = menu.registraLibro(biblioteca);
                 break;



            case 2: menu.trovaLibriPerPianoEScaffale(biblioteca);

                     break;

            case 3: menu.cercaLibroPerISBN(biblioteca);
                     break;

            case 4: menu.cercaLibroPerTitoloAutoreGenere(biblioteca);
                    break;
        }

    }
}
