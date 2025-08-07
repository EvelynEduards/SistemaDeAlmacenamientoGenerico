package completosistemadealmacenamientogenerico;

public interface GestonAlmacenProducto {
    
    static void mostrarContenido (Almacen<? extends Producto> almacen) {
    for (Producto p : almacen) {
        System.out.println(p);
        }
    }
    
    static void mostrarElectronicos(Almacen<? extends Producto> almacen) {
    //List<Producto> electronicos = (List<Producto>) almacen.filtrar(p -> p.getTipo() == Tipo.ELECTRONICO);
    
    //OTRA FORMA DE HACELO ES:
    almacen.filtrar(p -> p.getTipo() == Tipo.ELECTRONICO).forEach(p -> System.out.println(p));
    // Otra forma de hacer este ultimo en sintaxis es:
    //almacen.filtrar(p -> p.getTipo() == Tipo.ELECTRONICO).forEach(System.out::println);
    }
    
    static void mostrarProductosMas1500(Almacen<? extends Producto> almacen) {
    almacen.paraCadaElemento(p -> {
        if (p.getPrecio() > 1500) {
            System.out.println(p);
            }
        });
    
    //Lo mismo mas chiquito (LO DE ARRIBA ES MÁS EFICIENTE):
    /*
    almacen.filtrar(p -> p.getPrecio() > 1500).forEach(System.out::println);
    */
    }
    
    static void mostrarComestiblesAumentados(Almacen<? extends Producto> almacen) {
        
        almacen.transformar(p -> {
            p.setPrecio(p.getPrecio() * 1.05);
            return p;
        }).forEach(System.out::println);
    }
    
    static void mostrarMarcas(Almacen<? extends Producto> almacen){
        almacen.transformar(p -> p.getMarca()).forEach(System.out::println);
    }
}

    

