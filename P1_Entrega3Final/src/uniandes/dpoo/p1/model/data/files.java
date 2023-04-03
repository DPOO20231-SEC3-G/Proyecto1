package uniandes.dpoo.p1.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class files{
    public void crearFileServicios(){
        HashMap disp1 = new HashMap();
        HashMap disp2 = new HashMap();
        ArrayList horas = new ArrayList();
        ArrayList horas2 = new ArrayList();
        ArrayList horas3 = new ArrayList();
        ArrayList horas4 = new ArrayList();

        horas2.add(new Time(8,30,0));
        horas2.add(new Time(9,30,0));
        horas2.add(new Time(10,30,0));
        horas2.add(new Time(11,30,0));
        horas.add(new Time(8,30,0));
        horas.add(new Time(9,30,0));
        horas.add(new Time(10,30,0));
        horas.add(new Time(11,30,0));
        horas.add(new Time(14,30,0));
        horas.add(new Time(15,30,0));
        horas.add(new Time(16,30,0));
        horas3.add(new Time(20,0,0));
        horas3.add(new Time(21,0,0));
        horas3.add(new Time(22,0,0));
        horas3.add(new Time(23,0,0));
        horas3.add(new Time(00,0,0));
        horas3.add(new Time(1,0,0));
        horas3.add(new Time(2,0,0));
        horas3.add(new Time(3,0,0));
        horas4.add(new Time(20,0,0));
        horas4.add(new Time(21,0,0));
        horas4.add(new Time(22,0,0));
        horas4.add(new Time(23,0,0));

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
        HashMap serviciosfull = new HashMap();
        serviciosfull.put("Masaje",servicio1);
        serviciosfull.put("Montar a caballo",servicio2);
        serviciosfull.put("Rumba Nocturna",servicio3);

        ObjectOutputStream servicios = new ObjectOutputStream(new FileOutputStream("Servicios.txt"));
        servicios.writeObject(serviciosfull)
        servicios.close()
            }
    public void crearFileMenu(){
        HashMap disp1 = new HashMap();
        HashMap disp2 = new HashMap();
        HashMap disp3 = new HashMap();

        ArrayList horas1 = new ArrayList();
        ArrayList horas2 = new ArrayList();
        ArrayList horas3 = new ArrayList();

        horas1.add(new Time(8,30,0));
        horas1.add(new Time(9,30,0));
        horas1.add(new Time(10,30,0));
        horas2.add(new Time(12,0,0));
        horas2.add(new Time(1,0,0));
        horas2.add(new Time(2,0,0));
        horas3.add(new Time(18,0,0));
        horas3.add(new Time(19,0,0));
        horas3.add(new Time(20,0,0));

        disp1.put("Lunes",horas1);
        disp1.put("Martes",horas1);
        disp1.put("Miercoles",horas1);
        disp1.put("Jueves",horas1);
        disp1.put("Viernes",horas1);
        disp1.put("Sabado",horas1);
        disp1.put("Domingo",horas1);
        disp2.put("Viernes",horas2);
        disp2.put("Sabado",horas2);
        disp2.put("Domingo",horas2);
        disp2.put("Lunes",horas2);
        disp2.put("Martes",horas2);
        disp2.put("Miercoles",horas2);
        disp2.put("Jueves",horas2);
        disp3.put("Lunes",horas3);
        disp3.put("Martes",horas3);
        disp3.put("Miercoles",horas3);
        disp3.put("Jueves",horas3);
        disp3.put("Viernes",horas3);
        disp3.put("Sabado",horas3);
        disp3.put("Domingo",horas3);
        
        Servicio servicio1 = new Servicio("Pancakes",20,"Porción de 4 deliciosos pancakes acompañados de fresas y miel de maple.",false,disp1);
        Servicio servicio2 = new Servicio("Bandeja Paisa",45,"Porción del plato típico colombiano de frijoles con platano maduro, arroz, chicharron, dos arepitas pequeñas, una porción de hogao y carne molida.",false,disp2) ;
        Servicio servicio3 = new Servicio("Sushi",35,"Porción de 10 rollos de sushi de camarón son queso crema y aguacate acompañados con salsa de sye, teriyaki y wasabi.",false,disp3);
        HashMap serviciosfull = new HashMap();

        serviciosfull.put("Pancakes",servicio1);
        serviciosfull.put("Bandeja Paisa",servicio2);
        serviciosfull.put("Sushi",servicio3);

        ObjectOutputStream servicios = new ObjectOutputStream(new FileOutputStream("Restaurante.txt"));
        servicios.writeObject(serviciosfull)
        servicios.close()
    }

    public static void main(String[] args){
        crearFileMenu();
        crearFileServicios();
    }


}
