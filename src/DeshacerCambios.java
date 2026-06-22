import Grafos.Usuario;
import Pila.Pila;
import Pila.PilaConjunto;
import Conjuntos.Conjunto;

public class DeshacerCambios {
    private Pila historialNombres;
    private PilaConjunto historialFormaciones;


    public DeshacerCambios() {
        this.historialNombres = new Pila();
        this.historialFormaciones = new PilaConjunto();
    }


    public void modificarNombre(Usuario usuario, String nuevoNombre) {
        this.historialNombres.apilar(usuario.getNombre());
        usuario.setNombre(nuevoNombre);
    }


    public void deshacerNombre(Usuario usuario) {
        if (!this.historialNombres.pilaVacia()) {
            String nombreAnterior = (String) this.historialNombres.desapilar();
            usuario.setNombre(nombreAnterior);
        } else {
            System.out.println("No hay más cambios de nombre para deshacer.");
        }
    }


    public void modificarFormaciones(Usuario usuario, Conjunto nuevasFormaciones) {
        this.historialFormaciones.apilar(usuario.getFormaciones());
        usuario.setFormaciones(nuevasFormaciones);
    }


    public void deshacerFormaciones(Usuario usuario) {
        if (!this.historialFormaciones.pilaVacia()) {
            Conjunto formacionesAnteriores = this.historialFormaciones.desapilar();
            usuario.setFormaciones(formacionesAnteriores);
        } else {
            System.out.println("No hay más cambios de formaciones para deshacer.");
        }
    }
}
