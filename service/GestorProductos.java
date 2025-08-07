package service;

import completosistemadealmacenamientogenerico.Producto;
import completosistemadealmacenamientogenerico.Tipo;
import java.util.Comparator;
import java.util.List;


public interface GestorProductos {

    static void hardcodearProductos(List<? super Producto> lista){
        lista.add(new Producto(123, "Marca X", Tipo.COMESTIBLE, 189.5));
        lista.add(new Producto(128, "Marca H", Tipo.LIMPIEZA, 176.7));
        lista.add(new Producto(125, "Marca K", Tipo.COMESTIBLE, 109.2));
        lista.add(new Producto(198, "Marca M", Tipo.ELECTRONICO, 1779.5));
        lista.add(new Producto(143, "Marca M", Tipo.LIMPIEZA, 1234.5));
        lista.add(new Producto(382, "Marca X", Tipo.LIMPIEZA, 9283.4));
        lista.add(new Producto(927, "Marca H", Tipo.COMESTIBLE, 2384.9));
        lista.add(new Producto(267, "Marca M", Tipo.COMESTIBLE, 2838.5));
        lista.add(new Producto(883, "Marca M", Tipo.ELECTRONICO, 3747.8));
    }

    static void listarProductos(List<? extends Producto> lista){
        System.out.println("Lista de Productos:\n");
        lista.forEach(System.out::println);
    }

    static void ordenarProductos(List<Producto> lista, Comparator<? super Producto> comparador){
        lista.sort(comparador);
    }
}

