package uniandes.dpoo.p1.model.data;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;

import uniandes.dpoo.p1.model.Servicio;

public class fileserv implements Serializable {
    public static void main(String[] args) throws IOException{
    HashMap<String,ArrayList<Time>> disp1 = new HashMap<String,ArrayList<Time>>();
        HashMap<String,ArrayList<Time>> disp2 = new HashMap<String,ArrayList<Time>>();
        ArrayList<Time> horas = new ArrayList<Time>();
        ArrayList<Time> horas2 = new ArrayList<Time>();
        ArrayList<Time> horas3 = new ArrayList<Time>();
        ArrayList<Time> horas4 = new ArrayList<Time>();

        horas2.add(new Time(30600000));
        horas2.add(new Time(34200000));
        horas2.add(new Time(37800000));
        horas2.add(new Time(41400000 ));
        horas.add(new Time(30600000));
        horas.add(new Time(34200000));
        horas.add(new Time(37800000));
        horas.add(new Time(41400000));
        horas.add(new Time(52200000));
        horas.add(new Time(55800000));
        horas.add(new Time(59400000));
        horas3.add(new Time(72000000));
        horas3.add(new Time(75600000));
        horas3.add(new Time(79200000));
        horas3.add(new Time(82800000));
        horas3.add(new Time(86400000));
        horas3.add(new Time(3600000));
        horas3.add(new Time(7200000));
        horas3.add(new Time(10800000));
        horas4.add(new Time(72000000));
        horas4.add(new Time(75600000));
        horas4.add(new Time(79200000));
        horas4.add(new Time(82800000));

        disp1.put("Lunes",horas);
        disp1.put("Martes",horas);
        disp1.put("Miercoles",horas);
        disp1.put("Jueves",horas);
        disp1.put("Viernes",horas2);
        disp1.put("Sabado",horas2);
        disp1.put("Domingo",horas2);
        disp2.put("Viernes",horas4);
        disp2.put("Sabado",horas3);
        disp2.put("Domingo",horas3);
        disp2.put("Lunes",null);
        disp2.put("Martes",null);
        disp2.put("Miercoles",null);
        disp2.put("Jueves",null);
        
        Servicio servicio1 = new Servicio("Masaje",100,"Masaje relajante de cuerpo completo para una persona.",false,disp1);
        Servicio servicio2 = new Servicio("Montar a caballo",50,"Divertida cabalgata de 1 hora por nuestros boques y prados.",true,disp1) ;
        Servicio servicio3 = new Servicio("Rumba Nocturna",75,"Divertida festa nocturna únicamente para mayores de edad, con shows exclusivos que te llevaran a otro mundo.",false,disp2);
        HashMap<String,Servicio> serviciosfull = new HashMap<String,Servicio>();
        serviciosfull.put("Masaje",servicio1);
        serviciosfull.put("Montar a caballo",servicio2);
        serviciosfull.put("Rumba Nocturna",servicio3);

        ObjectOutputStream servicios = new ObjectOutputStream(new FileOutputStream("Servicios.dat"));
        servicios.writeObject(serviciosfull);
        servicios.close();
    }
}
