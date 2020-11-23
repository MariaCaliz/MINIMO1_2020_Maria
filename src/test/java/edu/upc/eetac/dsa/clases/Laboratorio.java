package edu.upc.eetac.dsa.clases;
import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Laboratorio {

    String idLab;
    String nombreLab;
    Queue<Muestra> colaMuestras;

    public Laboratorio(){

    }

    public Laboratorio(String idLab, String nombreLab, Queue<Muestra> colaMuestras){
        this.idLab = idLab;
        this.nombreLab =nombreLab;
        this.colaMuestras = colaMuestras;

    }




}
