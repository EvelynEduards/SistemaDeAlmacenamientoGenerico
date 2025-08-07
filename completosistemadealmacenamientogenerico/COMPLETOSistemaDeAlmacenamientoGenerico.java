package completosistemadealmacenamientogenerico;

import java.util.List;

public class COMPLETOSistemaDeAlmacenamientoGenerico {

    public static void main(String[] args) {
        /*
        
        Almacen<Integer> almacen = new Almacen<>();
        almacen.agregar(23);
        almacen.agregar(21);
        almacen.agregar(7);
        almacen.agregar(8);
        almacen.agregar(2);
        almacen.agregar(9);
        
        System.out.println(almacen.tamanio());
        
        // PROBAMOS CONTIENE() 
        System.out.println(almacen.contiene(7));
        System.out.println(almacen.contiene(17));
        
        // PROBAMOS REMOVE Y VERIFICAMOS CON CONTIENE()
        almacen.eliminar(7);
        System.out.println(almacen.contiene(7));
        
        // CHEQUEAMOS EL TAMANIO DEL ALMACEN NUEVAMENTE
        System.out.println(almacen.tamanio());
        
        // PROBAMOS EJECUTAR ELIMINAR X INDICE
        almacen.eliminarPorIndice(0);
        System.out.println(almacen.contiene(23)); // VEMOS QUE ELIMINO EL 23
        
        //LAMBDA
        sort(productos, (Producto p1, Producto p2) -> return Double.compare(p1.getPrecio(), p2.getPrecio()));
        ACHICADO:
        sort(productos, (p1, p2) -> Double.compare(p1.getPrecio(), p2.getPrecio()));
        ORDEN X TIPO
        sort(productos, (p1, p2) -> p1.getTipo().compareTo(p2.getTipo()));
        ORDEN POR NOMBRE DEL TIPO
        sort(productos, (p1, p2) -> p1.getTipo().name().compareTo(p2.getTipo().name()));
        PRIMERO POR ORDEN DESPUÉS POR TIPO
        sort(productos, (p1, p2) -> {
        int cmp = p1.getMarca().compareTo(p2.getMarca());
        if (cmp == 0) {
            return p1.getTipo().name().compareTo(p2.getTipo().name());
        }
        return cmp;
        });
        */
        
        
        
        /*
        
        Almacen<String> almacen = new Almacen<>();
        almacen.agregar("Juan");
        almacen.agregar("Pedro");
        almacen.agregar("Lucia");
        almacen.agregar("Maria");
        
        System.out.println(almacen.tamanio());
        // TRAEMOS EL ULTIMO VALOR DEL ARRAYLIST
        System.out.println(almacen.obtener(almacen.tamanio() -1));
        
        */
        
        Almacen<Producto> almacen = new Almacen<>();
        almacen.agregar(new Producto(123, "Marca X", Tipo.COMESTIBLE, 189.5));
        almacen.agregar(new Producto(128, "Marca H", Tipo.LIMPIEZA, 176.7));
        almacen.agregar(new Producto(125, "Marca K", Tipo.COMESTIBLE, 109.2));
        almacen.agregar(new Producto(198, "Marca M", Tipo.ELECTRONICO, 1779.5));
        almacen.agregar(new Producto(143, "Marca M", Tipo.LIMPIEZA, 1234.5));
        almacen.agregar(new Producto(382, "Marca X", Tipo.LIMPIEZA, 9283.4));
        almacen.agregar(new Producto(927, "Marca H", Tipo.COMESTIBLE, 2384.9));
        almacen.agregar(new Producto(267, "Marca M", Tipo.COMESTIBLE, 2838.5));
        almacen.agregar(new Producto(883, "Marca M", Tipo.ELECTRONICO, 3747.8));
        almacen.agregar(new Producto(1, "Marca A", Tipo.COMESTIBLE, 1000));
        almacen.agregar(new Producto(2, "Marca B", Tipo.ELECTRONICO, 2500));
        almacen.agregar(new Producto(3, "Marca C", Tipo.LIMPIEZA, 1500));

        
        //System.out.println(almacen.tamanio());
        //System.out.println(almacen.obtener(2));
        
        //almacen.mostrarContenido();
        System.out.println("-----------------------------------------------------------------------");
        //Mostrar contenido comparando por marca
        //almacen.mostrarContenido(new ComparadorProductoMarca()); 
        
       GestonAlmacenProducto.mostrarElectronicos(almacen);
       
       System.out.println("PRODUCTOS MÁS DE 1500:");
       GestonAlmacenProducto.mostrarProductosMas1500(almacen);
       
       System.out.println("-----------------------------------------------------------------------");
       
       GestonAlmacenProducto.mostrarComestiblesAumentados(almacen);
       
      System.out.println("-----------------------------------------------------------------------");
      
      GestonAlmacenProducto.mostrarMarcas(almacen);
    
    
        // ------------------ PERSISTENCIA ------------------
    System.out.println("\n=========== GUARDANDO EN ARCHIVOS ===========");

    // Guardar productos en archivos
    repository.PersistenciaProductos.serializar(almacen, config.RutasArchivo.getRutaBinString());
    repository.PersistenciaProductos.guardarCSV(almacen, config.RutasArchivo.getRutaCSVString());

    // Cargar desde archivos (obtengo List<Producto>)
    List<Producto> listaDesdeBin = repository.PersistenciaProductos.deserializar(config.RutasArchivo.getRutaBinString());
    List<Producto> listaDesdeCSV = repository.PersistenciaProductos.cargarCSV(config.RutasArchivo.getRutaCSVString());

    // Crear almacenes y cargar las listas
    Almacen<Producto> desdeBin = new Almacen<>();
    Almacen<Producto> desdeCSV = new Almacen<>();

    if (listaDesdeBin != null) {
        desdeBin.setItems(listaDesdeBin);
    }
    if (listaDesdeCSV != null) {
        desdeCSV.setItems(listaDesdeCSV);
    }

    // Mostrar lo recuperado
    System.out.println("\n=========== PRODUCTOS DESDE BIN ===========");
    desdeBin.mostrarContenido();

    System.out.println("\n=========== PRODUCTOS DESDE CSV ===========");
    desdeCSV.mostrarContenido();
}
}