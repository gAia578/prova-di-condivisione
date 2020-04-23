public class Libro {

    private String titolo;
    private String nomeAutore;
    private String argomento;
    private String codiceISBN;




    public Libro(String titolo, String nomeAutore, String argomento, String codiceISBN) {

        this.titolo = titolo;
        this.nomeAutore = nomeAutore;
        this.argomento = argomento;
        this.codiceISBN = codiceISBN;

    }



    public String getTitolo() {
        return this.titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getNomeAutore() {
        return this.nomeAutore;
    }

    public void setNomeAutore(String nomeAutore) {
        this.nomeAutore = nomeAutore;
    }

    public String getArgomento() {
        return this.argomento;
    }

    public void setArgomento(String argomento) {
        this.argomento = argomento;
    }

    public String getCodiceISBN() {
        return this.codiceISBN;
    }

    public void setCodiceISBN(String codiceISBN) {
        this.codiceISBN = codiceISBN;
    }

    public void getMostraLibro() {

        System.out.println("Il libro che hai scelto è: " + "Titolo: " + this.getTitolo() +", " + "Autore " + this.getNomeAutore() + ", " + "Argomento " + this.getArgomento() + ", " + "Codice ISBN" + this.getCodiceISBN());
    }

    private String piano;
    private String scaffale;
    private int numeroLibri;
    private String codiceCatalogazione;


    public void creaCodiceCatalogazione(String piano, String scaffale, int numeroLibri) {



        this.piano=piano;
        this.scaffale=scaffale;
        this.numeroLibri=numeroLibri;
        this.codiceCatalogazione = piano+scaffale+numeroLibri;

    }

    public String getPiano() {
        return this.piano;
    }
    public void setPiano(String piano) {
        this.piano=piano;
    }
    public String getScaffale(){
        return this.scaffale;
    }
    public void setScaffale(String scaffale){
        this.scaffale=scaffale;
    }
    public int getNumeroLibri() {
        return this.numeroLibri;
    }
    public void setNumeroLibri(int numeroLibri){
        this.numeroLibri=numeroLibri;
    }


    public String getCodiceCatalogazione() {
        return this.codiceCatalogazione;
    }




    public void visualizzaCodiceCatalogazione () {
        System.out.println( "Piano: " + this.getPiano() + "Scaffale " + this.getScaffale() + this.getNumeroLibri() + this.getCodiceCatalogazione() );
    }

    public String combinaCodice(){
        return (piano+scaffale+numeroLibri);
    }


}


