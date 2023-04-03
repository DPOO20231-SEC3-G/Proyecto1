package uniandes.dpoo.p1.model.data;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;

import uniandes.dpoo.p1.model.Servicio;

public class Files {

    /**
     * @param args
     * @throws IOException
     */
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

        ObjectOutputStream servicios = new ObjectOutputStream(new FileOutputStream("Servicios.txt"));
        servicios.writeObject(serviciosfull);
        servicios.close();
           
        HashMap<String,ArrayList<Time>> disp3 = new HashMap<String,ArrayList<Time>>();
        HashMap<String,ArrayList<Time>> disp4 = new HashMap<String,ArrayList<Time>>();
        HashMap<String,ArrayList<Time>> disp5 = new HashMap<String,ArrayList<Time>>();

        ArrayList<Time> horas5 = new ArrayList<Time>();
        ArrayList<Time> horas6 = new ArrayList<Time>();
        ArrayList<Time> horas7 = new ArrayList<Time>();

        horas5.add(new Time(30600000));
        horas5.add(new Time(34200000));
        horas5.add(new Time(37800000));
        horas6.add(new Time(43200000));
        horas6.add(new Time(46800000));
        horas6.add(new Time(50400000));
        horas7.add(new Time(64800000));
        horas7.add(new Time(68400000));
        horas7.add(new Time(72000000));

        disp3.put("Lunes",horas5);
        disp3.put("Martes",horas5);
        disp3.put("Miercoles",horas5);
        disp3.put("Jueves",horas5);
        disp3.put("Viernes",horas5);
        disp3.put("Sabado",horas5);
        disp3.put("Domingo",horas5);
        disp4.put("Viernes",horas6);
        disp4.put("Sabado",horas6);
        disp4.put("Domingo",horas6);
        disp4.put("Lunes",horas6);
        disp4.put("Martes",horas6);
        disp4.put("Miercoles",horas6);
        disp4.put("Jueves",horas6);
        disp5.put("Lunes",horas7);
        disp5.put("Martes",horas7);
        disp5.put("Miercoles",horas7);
        disp5.put("Jueves",horas7);
        disp5.put("Viernes",horas7);
        disp5.put("Sabado",horas7);
        disp5.put("Domingo",horas7);
        
        Servicio servicio4 = new Servicio("Pancakes",20,"Porción de 4 deliciosos pancakes acompañados de fresas y miel de maple.",false,disp3);
        Servicio servicio5 = new Servicio("Bandeja Paisa",45,"Porción del plato típico colombiano de frijoles con platano maduro, arroz, chicharron, dos arepitas pequeñas, una porción de hogao y carne molida.",false,disp4) ;
        Servicio servicio6 = new Servicio("Sushi",35,"Porción de 10 rollos de sushi de camarón son queso crema y aguacate acompañados con salsa de sye, teriyaki y wasabi.",false,disp5);
        HashMap<String,Servicio> serviciosfull2 = new HashMap<String,Servicio>();

        serviciosfull2.put("Pancakes",servicio4);
        serviciosfull2.put("Bandeja Paisa",servicio5);
        serviciosfull2.put("Sushi",servicio6);

        ObjectOutputStream servicioss = new ObjectOutputStream(new FileOutputStream("Restaurante.txt"));
        servicioss.writeObject(serviciosfull2);
        servicioss.close();
    }

    

}
