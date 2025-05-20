import java.util.ArrayList;
import java.util.List;

public class Lista {
    private List<Transformer> lista;
    //Generar el constructor
    public Lista() {
        //Instanciar la lista
        lista=new ArrayList<>();
    }

    //Metodos
    public void agregar(Transformer dato){
        lista.add(dato);
    }
    //Metodo publico
    public float sumarPoder(){
        return sumaRecursiva(0);
    }
    private float sumaRecursiva(int indice){
        //Caso base
        if (indice>=lista.size())
            return 0;
            //Caso recursivo
        else
            return lista.get(indice).getNivelPoder()+
                    sumaRecursiva(indice+1);
    }

    //Metodos para sumar segun la faccion (Autobot o Decepticon)
    public float sumarPoderFaccion(String faccion){
        return sumarPoderFaccionRecursiva(faccion,0);
    }

    private float sumarPoderFaccionRecursiva(String faccion, int indice){
        // Caso base
        if (indice >= lista.size()) {
            return 0;
        } else {
            Transformer t = lista.get(indice);
            float suma = 0;

            if (t.getFaccion().equalsIgnoreCase(faccion)) {
                suma = t.getNivelPoder();
            }

            // Caso recursivo
            return suma + sumarPoderFaccionRecursiva(faccion, indice + 1);
        }
    }

    public String listar(){
        StringBuilder sb=new StringBuilder();
        for (Transformer t:lista){
            sb.append(t.toString()+"\n");
        }
        return sb.toString();
    }


}