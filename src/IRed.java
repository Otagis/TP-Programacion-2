import Conjuntos.Conjunto;
import Diccionari.DictStr;

public interface IRed {
    void iniciarDemo();
    void logIn(String nombre, DictStr ins);
    void logOut();
    void recomendaciones(Conjunto formacion);
    void restaurarCambios();
}
