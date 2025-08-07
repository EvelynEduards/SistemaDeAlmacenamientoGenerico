package repository;


import completosistemadealmacenamientogenerico.Almacen;
import completosistemadealmacenamientogenerico.Producto;
import java.io.*;
import java.util.ArrayList;
import java.util.List;



public interface PersistenciaProductos {

    public static void guardarCSV(Almacen<Producto> almacen, String path) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.write(Producto.toCSVHeader());
            for (Producto p : almacen.getItems()) {
                    bw.write(p.toCSV() + "\n");
                }
        } catch (IOException ex) {
            System.out.println("Error al guardar CSV: " + ex.getMessage());
        }
    }

    static List<Producto> cargarCSV(String path) {
        
    List<Producto> lista = null;
    
    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
        lista = new ArrayList<>();
        String linea;
        br.readLine(); 
        while ((linea = br.readLine()) != null) {
            Producto p = Producto.fromCSV(linea);
            lista.add(p);
        }
        } catch (IOException ex) {
            System.out.println("Error al cargar CSV: " + ex.getMessage());
        }
        return lista;
    }


    public static void serializar(Almacen<Producto> almacen, String path) {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(path))) {
            salida.writeObject(almacen.getItems());
        } catch (IOException ex) {
            System.out.println("Error al serializar: " + ex.getMessage());
        }
    }

    static List<Producto> deserializar(String path) {
    
    List<Producto> toReturn = null;
    
    try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(path))) {
        toReturn = (List<Producto>) entrada.readObject();
    } catch (IOException | ClassNotFoundException ex) {
        System.out.println("Error al deserializar: " + ex.getMessage());
    }
    return toReturn;
}

}