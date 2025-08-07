package completosistemadealmacenamientogenerico;

import java.util.Objects;

    import java.io.Serializable;

public class Producto implements Comparable<Producto>, Serializable {
    private static final long serialVersionUID = 1L;   
    private final int id;
    private final String marca;
    private final Tipo tipo;
    private double precio;

    public Producto(int id, String marca, Tipo tipo, double precio) {
        this.id = id;
        this.marca = marca;
        this.tipo = tipo;
        this.precio = precio;
    }
    
    public Producto(Producto p) {
    this.id = p.getId();
    this.marca = p.getMarca();
    this.tipo = p.getTipo();
    this.precio = p.getPrecio();
    }
    
    public int getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    

    @Override
    public boolean equals(Object o){
        if(o == null || !(o instanceof Producto p)){
            return false;
        }
        return p.id == id;
    }
    
    public boolean esTipo(Tipo tipo){
    return this.tipo == tipo;
    }
    
    
    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
    
    @Override
    public String toString() {
        return """
               Producto: 
                 ID: """ + id + "\n" +
               "  Marca: " + marca + "\n" +
               "  Tipo: " + tipo + "\n" +
               "  Precio: $" + String.format("%.2f", precio) + "\n";
    }


    @Override
    public int compareTo(Producto p) {
        return Integer.compare(id, p.id);
    }
    
    public static String toCSVHeader() {
    return "ID,Marca,Tipo,Precio\n";
    }
    
    public String toCSV() {
    return id + "," + marca + "," + tipo + "," + precio;
}

    public static Producto fromCSV(String productoCSV) {
    if (productoCSV.endsWith("\n")) {
        productoCSV = productoCSV.substring(0, productoCSV.length() - 1);
    }
    String[] campos = productoCSV.split(",");
    if (campos.length == 4) {
        int id = Integer.parseInt(campos[0].trim());
        String marca = campos[1].trim();
        Tipo tipo = Tipo.valueOf(campos[2].trim());
        double precio = Double.parseDouble(campos[3].trim());
        return new Producto(id, marca, tipo, precio);
    }
    return null;
}


}
