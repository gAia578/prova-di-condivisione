import java.util.List;
import java.util.ArrayList;

public class Scaffale {

    private List<Libro> libri;

    public Scaffale() {
        libri = new ArrayList<>();

    }


    public List<Libro> getLibri(){
        return libri;
    }

    public int aggiungiLibro(Libro libro){
        libri.add(libro);
        int numeroLibri = libri.size();
        libro.setNumeroLibri(numeroLibri);
        return numeroLibri;
    }

}
