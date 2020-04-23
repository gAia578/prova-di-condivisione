import java.util.List;
import java.util.ArrayList;

public class Biblioteca {

    public Biblioteca(int numeroPiani){
        piani = new Piano[numeroPiani];
    }
    Piano[] piani = new Piano [3];
    String [] nomePiani = {"PT", "PP", "SP"};
    private int [] numeroScaffali = {4, 12, 10};
    private String [] lettereScaffali = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "L", "M", "N"};


    public Piano[] getPiani() {
        return piani;
    }



    public void aggiungiLibro(Libro libro, String scaffale, String piano) {

        int i=0;
        for (; i<nomePiani.length; i++){
            if (nomePiani[i].equals(piano)) {
                break;

            }

        }
        if(piani[i] ==null){
            piani[i] = new Piano(numeroScaffali[i]);
        }
        piani[i].aggiungiLibro(libro,scaffale);

    }

    public void cercaPerPianoEScaffale (int piano, String scaffale){
        int indiceScaffale = 0;
        for (int i=0; i<lettereScaffali.length; i++){

            if (lettereScaffali[i].equals(scaffale)) {
                indiceScaffale=i;

                break;

            }

        }

        for(int i=0; i<piani.length; i++){//scorro i piani
            if(piani [i]!= null && i==piano){       //se il piano non è vuoto ed il piano è corrispondente a quello che sto guardando
                for(int j=0; j<piani[i].getScaffali().length; j++){
                    if(piani[i].getScaffali()[j] != null && j==indiceScaffale){//è l'array che dentro ha tutti gli scaffali
                        for (int z=0; z<piani[i].getScaffali()[j].getLibri().size(); z++){
                            piani[i].getScaffali()[j].getLibri().get(z).getMostraLibro();
                            piani[i].getScaffali()[j].getLibri().get(z).visualizzaCodiceCatalogazione();


                        }
                    }
                }

            }
        }


    }
    public void cercaLibroPerISBN (String ISBN) {
        int temp =0;

        for(int i=0; i<piani.length; i++){//scorro i piani
            if(piani [i]!= null){       //se il piano non è vuoto ed il piano è corrispondente a quello che sto guardando
                for(int j=0; j<piani[i].getScaffali().length; j++){
                    if(piani[i].getScaffali()[j] != null ){//è l'array che dentro ha tutti gli scaffali
                        for (int z=0; z<piani[i].getScaffali()[j].getLibri().size(); z++){
                            if(ISBN.equals(piani[i].getScaffali()[j].getLibri().get(z).getCodiceISBN())) {
                                temp=1;
                                piani[i].getScaffali()[j].getLibri().get(z).getMostraLibro();
                                piani[i].getScaffali()[j].getLibri().get(z).visualizzaCodiceCatalogazione();
                            }

                        }
                    }
                }

            }
        }
        if(temp==0){
            System.out.println(" Non c'è nessun libro corrispondente al codice ISBN che hai insertito");
        }



    }
//creo la lista che mi da tutti i libri

    public List<Libro> getTuttiILibri(){

        List<Libro> tuttiILibri = new ArrayList<Libro>();

        for(int i=0; i<piani.length; i++){
            if(piani [i]!= null){
                for(int j=0; j<piani[i].getScaffali().length; j++){
                    if(piani[i].getScaffali()[j] != null ){//è l'array che dentro ha tutti gli scaffali
                        for (int z=0; z<piani[i].getScaffali()[j].getLibri().size(); z++){
                            tuttiILibri.add(piani[i].getScaffali()[j].getLibri().get(z));
                                piani[i].getScaffali()[j].getLibri().get(z).getMostraLibro();
                                piani[i].getScaffali()[j].getLibri().get(z).visualizzaCodiceCatalogazione();


                        }
                    }
                }

            }
        }
        return tuttiILibri;

    }
//creo la lista per cercare i libri per titolo. Passo la lista con un for each e se contiene il titolo lo aggiunge alla lista libriPerTitolo

    public List<Libro> cercaPerTitolo(String titolo, List<Libro> lista){

        List<Libro> libriPerTitolo = new ArrayList<Libro>();

        for(Libro libro : lista){
            if( libro.getTitolo().contains(titolo)){
                libriPerTitolo.add(libro);
            }
        }

        return libriPerTitolo;
    }
  // cerca per nome autore

    public List<Libro> cercaPerNomeAutore(String nomeAutore, List<Libro> lista){

        List<Libro> libriPerAutore = new ArrayList<Libro>();
        for(Libro libro : lista){
            if( libro.getNomeAutore().equals(nomeAutore)){
                libriPerAutore.add(libro);
            }
        }

        return libriPerAutore;
    }
    // cerca per argomento

    public List<Libro> cercaPerArgomento(String argomento, List<Libro> lista){

        List<Libro> libriPerArgomento = new ArrayList<Libro>();
        for(Libro libro : lista){
            if( libro.getArgomento().equals(argomento)){
                libriPerArgomento.add(libro);
            }
        }

        return libriPerArgomento;
    }

    //prendo la lista e vedo se il titolo inserito è diverso da una stringa vuota e allora  si ricerca per titolo

    public void cercaLibroPerTitoloAutoreGenere(String titolo, String nomeAutore, String argomento){
        List<Libro> tuttiILibri = getTuttiILibri();


        if (!titolo.equals (" ")){
            tuttiILibri=cercaPerTitolo(titolo, tuttiILibri);

        }

        if(!nomeAutore.equals( " " )){
            tuttiILibri = cercaPerNomeAutore (nomeAutore, tuttiILibri);

        }

        if(!argomento.equals( " " )){
            tuttiILibri = cercaPerArgomento (argomento, tuttiILibri);

        }

        if(tuttiILibri.size() > 0) {
            for (Libro libro : tuttiILibri) {
                libro.getMostraLibro();
                libro.visualizzaCodiceCatalogazione();
            }
        }else {
            System.out.println("Non ci sono libri corrispondenti alla tua richiesta");
        }



    }
}
