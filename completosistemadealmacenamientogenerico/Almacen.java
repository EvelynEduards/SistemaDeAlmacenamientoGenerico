package completosistemadealmacenamientogenerico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Almacen<T> implements Almacenable<T> {
    
    private List<T> items = new ArrayList<>();
   
    @Override
    public void agregar(T item) {
        checkItem(item);
        items.add(item);
    }

    @Override
    public T obtener(int indice) {
        checkIndex(indice);
        return items.get(indice);
    }
    
    public void checkItem(T item){
    if(item == null) {
        throw new NullPointerException("ITEM NULO.");
    }
    if(contiene(item)){
        throw new IllegalArgumentException("ITEM REPETIDO.");
    }
    }
    
    private void validarItemNoNulo(T item) {
    if (item == null) {
        throw new NullPointerException("ITEM NULO.");
    }
}

    private void validarItemExiste(T item) {
        if (!contiene(item)) {
            throw new IllegalArgumentException("ITEM NO EXISTE.");
        }
    }

    @Override
    public void eliminarPorIndice(int indice) {
        checkIndex(indice);
        items.remove(indice);
    }
    
    private void checkIndex(int indice){
        if(indice < 0 || indice > items.size() - 1){
            throw new IndexOutOfBoundsException("INDICE NO VALIDO.");
        } 
    }
    
    @Override
    public boolean eliminar(T item) {
        validarItemNoNulo(item);
        validarItemExiste(item);
        return items.remove(item);
    }

    @Override
    public boolean contiene(T item) {
        validarItemNoNulo(item);
       return items.contains(item);
    }

    @Override
    public int tamanio() {
        return items.size();
    }

    @Override
    public Iterator<T> iterator() {
        if (!items.isEmpty() && obtener(0) instanceof Comparable) {
            List<T> copia = new ArrayList<>(items);
            //copia.sort((Comparator<? super T>) Comparator.naturalOrder()); //una forma de hacerlo
            Collections.sort(copia, (Comparator<? super T>) Comparator.naturalOrder()); //segunda forma de hacerlo
            return copia.iterator();
        }
        return items.iterator();
    }

    public Iterator<T> iterator(Comparator<? super T> comparador) {
    List<T> copia = new ArrayList<>(items);
    //copia.sort((Comparador);
    Collections.sort(copia, comparador);
    return copia.iterator();
    }

    @Override
    public void mostrarContenido() {
        for(T p : this) {
            System.out.println(p);
    }
    }

    @Override
    public void mostrarContenido(Comparator<? super T> comparador) {
        Iterator<T> it = iterator(comparador);
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    @Override
    public List<T> filtrar(Predicate<? super T> criterio) {
        List<T> filtrados = new ArrayList<>();
    for (T item : items) {
        if (criterio.test(item)) {
            filtrados.add(item);
        }
    }
    return filtrados;
        }
    
    @Override
    public void paraCadaElemento(Consumer<? super T> accion) {
        for (T item : this) {
            accion.accept(item);
        }
    }
    
    @Override
    public <R>List<R> transformar(Function<? super T, ? extends R> transformacion) {
        List<R> toReturn = new ArrayList<>();
        for (T item : items) {
            toReturn.add(transformacion.apply(item));
        }
        return toReturn;
    }
 
    
    public List<T> getItems() {
    return items;
    }

    public void setItems(List<T> nuevaLista) {
        validarListaNoNula(nuevaLista);
        items = nuevaLista;
    }
    
    private void validarListaNoNula(List<T> lista) {
    if (lista == null) {
        throw new IllegalArgumentException("Lista no puede ser null");
    }
}
}

