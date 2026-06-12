package Diccionari;
import Grafos.Usuario;

public class TestDict {
    static void main() {
        DictStr dict = new DictStr(5);

        System.out.println(dict.recuperarValor("chinchu").getNombre());
    }
}
