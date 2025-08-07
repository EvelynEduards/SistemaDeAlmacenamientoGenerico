package config;

import java.nio.file.Path;
import java.nio.file.Paths;

public interface RutasArchivo {
    
    static final String BASE = "src/resources";
    
    static final String FILE_CSV = "productos.csv";
    
    static final String FILE_BIN = "productos.bin";
    
    public static Path getRutaCSV(){
        return Paths.get(BASE, FILE_CSV);
    }
    
    public static Path getRutaBin(){
        return Paths.get(BASE, FILE_BIN);
    }
    
    public static String getRutaCSVString(){
        return getRutaCSV().toString();
    }
    
    public static String getRutaBinString(){
        return getRutaBin().toString();
    }  
}
