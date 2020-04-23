import java.util.Scanner;
import java.util.List;

public class Menu {

    public int menu() {


        System.out.println("1) Registra nuovo libro con piano e scaffale");
        System.out.println("2) Trova un libro nel catalogo inserendo piano e scaffale");
        System.out.println("3) Cerca un libro inserendo il codice ISBN del libro");
        System.out.println("4) Cerca un libro inserendo titolo/autore/argomento del libro");
        System.out.println("0) Esci");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public Libro registraLibro(Biblioteca biblioteca){

        Scanner scanner = new Scanner (System.in);
        System.out.println("Titolo: ");
        String titolo = scanner.nextLine();
        System.out.println("Autore: ");
        String autore = scanner.nextLine();
        System.out.println("Argomento: ");
        String argomento = scanner.nextLine();
        System.out.println("Codice ISBN: ");
        String codiceISBN = scanner.nextLine();

        Libro libro = new Libro(titolo, autore, argomento, codiceISBN);

        System.out.println("Inserisci il piano dove catalogare il libro: ");
        String piano = scanner.nextLine();

        System.out.println("Inserisci la lettera dello scaffale dove catalogare il libro: ");
        String scaffale = scanner.nextLine();

        biblioteca.aggiungiLibro(libro, scaffale, piano);
        libro.creaCodiceCatalogazione(piano, scaffale, libro.getNumeroLibri());

        return libro;
    }

    public String trovaLibriPerPianoEScaffale(Biblioteca biblioteca){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il piano per trovare il libro: \n0) PT  \n1) PP  \n2) SP ");
        String p = scanner.nextLine();
        int piano = Integer.parseInt(p);
        System.out.println("Inserisci codice scaffale per trovare il libro: ");
        String scaffale = scanner.nextLine();

        biblioteca.cercaPerPianoEScaffale(piano, scaffale);

        return (piano+scaffale);

    }

    public void cercaLibroPerISBN(Biblioteca biblioteca){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il codice ISBN del libro da cercare: ");
        String ISBN = scanner.nextLine();

        biblioteca.cercaLibroPerISBN(ISBN);

    }

    public void cercaLibroPerTitoloAutoreGenere (Biblioteca biblioteca){

        System.out.println("Lascia vuoto se non vuoi ricercare uno dei campi sottostanti");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci il titolo o parte del titolo del libro da cercare: ");
        String titolo = scanner.nextLine();

        System.out.println("Inserisci il nome dell'autore del libro da cercare: ");
        String nomeAutore = scanner.nextLine();

        System.out.println("Inserisci l'argomento del libro da cercare: ");
        String argomento = scanner.nextLine();

        biblioteca.cercaLibroPerTitoloAutoreGenere(titolo, nomeAutore, argomento);

    }


}
