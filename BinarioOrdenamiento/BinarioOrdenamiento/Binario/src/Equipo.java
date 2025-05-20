import java.util.ArrayList;
import java.util.List;

public class Equipo {
    List<Jugador> lista;
    private int secuencia=0;

    public Equipo() {
        lista=new ArrayList<>();
    }

    public void agregarJugador(Jugador nuevo) throws Exception {
       // secuencia++;
       // nuevo.setCodigo(secuencia);
        for (Jugador j:lista){
            if(j.getCodigo()==nuevo.getCodigo())
                throw new Exception("El codigo no es unico");
        }
        lista.add(nuevo);
        ordenar();
    }

    public Jugador editarJugador(int codigo, String nuevoNombre, float nuevoRendimiento, String nuevaPosicion) throws Exception {
        for (Jugador j:lista){
            if (j.getCodigo()== codigo){
                j.setNombre(nuevoNombre);
                j.setRendimiento(nuevoRendimiento);
                j.setPosicion(nuevaPosicion);
                return j;
            }
        }
        throw new Exception("Jugador no encontrado ");
    }

    public void eliminarJugador(int codigo) throws Exception {
        Jugador jugadorAEliminar = null;
        for (Jugador j : lista) {
            if (j.getCodigo() == codigo) {
                jugadorAEliminar = j;
                break;
            }
        }
        if (jugadorAEliminar != null) {
            lista.remove(jugadorAEliminar);
        } else {
            throw new Exception("Jugador no encontrado");
        }
    }


    //Metodo burbuja
    public void ordenar() {
        Jugador aux;
        for (int i = 0; i < lista.size() ; i++) {
            for (int j = 0; j < lista.size() - 1 ; j++) {
                if (lista.get(j).getCodigo() > lista.get(j + 1).getCodigo()) {
                    aux = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, aux);
                }
            }
        }
    }

    /*    public void ordenar(){
        Jugador aux;
        for(int i=0; i<lista.size()-1;i++){
            for(int j=i+1; j<lista.size();j++){
                    if(lista.get(i).getCodigo()>lista.get(j).getCodigo()){
                        aux=lista.get(i);
                        lista.set(i,lista.get(j));
                        lista.set(j,aux);
                    }
            }

        }*/

    public String listarTodos(){
        StringBuilder sb=new StringBuilder();
        for(Jugador j:lista){
            sb.append(j.toString());
        }
        return sb.toString();
    }

    public Jugador buscarJugador(int codigo) throws Exception{
        if(codigo<lista.getFirst().getCodigo() ||
                codigo>lista.getLast().getCodigo()){
            throw new Exception("Codigo no esta en la lista");
        }
        int inf=0;
        int sup=lista.size()-1;
        int cen;
        while(inf<=sup){
            cen=(inf+sup)/2;
            if(lista.get(cen).getCodigo()==codigo){
                return lista.get(cen);
            }else if(codigo<lista.get(cen).getCodigo()){
                sup=cen-1;
            }else{
                inf=cen+1;
            }
        }
        throw new Exception("El codigo no esta dentro de la lista");
    }
}
