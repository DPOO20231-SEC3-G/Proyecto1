package uniandes.dpoo.p1.model.data;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

import uniandes.dpoo.p1.model.Huesped;

public class filehuesp implements Serializable{
    public static void main(String[] args) throws IOException{
        Huesped huesped1 = new Huesped("Andrea", 18, 1828393, "am23@gmail.com", 111);
        Huesped huesped2 = new Huesped("Pedro", 23, 1828394, "princon@gmail.com", 111);
        Huesped huesped3 = new Huesped("Juana", 57, 1828385, "juanamedina@gmail.com", 122);
        Huesped huesped4 = new Huesped("Maria", 55, 1828386, "Mariaa@gmail.com", 122);
        Huesped huesped5 = new Huesped("Alejandro", 57, 1828380, "aem10@gmail.com", 123);


        HashMap<Integer,Huesped> huespedes = new HashMap<Integer,Huesped>();
        huespedes.put(1828393,huesped1);
        huespedes.put(1828394,huesped2);
        huespedes.put(1828385,huesped3);
        huespedes.put(1828386,huesped4);
        huespedes.put(1828380,huesped5);

        ObjectOutputStream servicios = new ObjectOutputStream(new FileOutputStream("Huespedes.dat"));
        servicios.writeObject(huespedes);
        servicios.close();
        }}
