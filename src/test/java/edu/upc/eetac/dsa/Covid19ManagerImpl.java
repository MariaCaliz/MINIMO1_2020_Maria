package edu.upc.eetac.dsa;
import edu.upc.eetac.dsa.clases.*;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.logging.LogManager;
import org.apache.log4j.Logger;


public class Covid19ManagerImpl implements Covid19Manager{

    //Singleton
    private static Covid19Manager instance;

    private static Logger log = Logger.getLogger(Covid19Manager.class);

    //Estructuras de datos
    //Hashmap is a dictionary
    private HashMap<String,Persona> diccionarioPersona;
    private HashMap<String,Muestra> diccionarioMuestra;
    private List<Muestra> muestrasPersona;
    private Queue<Muestra> colaMuestrasPendientes;
    private List<Laboratorio> listaLaboratorios;

    //Singleton constructor privado
    private Covid19ManagerImpl(){
        this.diccionarioPersona = new HashMap<String,Persona>();
        this.colaMuestrasPendientes = new LinkedList<Muestra>();
        this.listaLaboratorios = new LinkedList<Laboratorio>();
        this.muestrasPersona = new LinkedList<Muestra>();
    }

    //Singleton
    public static Covid19Manager getInstance(){
        if (instance==null) instance = new Covid19ManagerImpl();
        return instance;
    }

    @Override
    public int añadirPersona(String idPersona, String nombrePersona, String apellidos, int edad, String salud)
    {
        try{
            diccionarioPersona.put(idPersona, new Persona(idPersona, nombrePersona, apellidos,edad,salud));
            log.info("Persona añadidad: " + nombrePersona);
            return 201; //OK
        }
        catch (IndexOutOfBoundsException e){
            log.error("UserMap Full Error");
            return 507; //No storage
        }
        catch (IllegalArgumentException e){
            log.error("Incorrect format exception");
            return 400; //error
        }
    }

    @Override
    public int añadirMuestraPersona(String idPersona, Muestra muestra, Laboratorio laboratorio) {
        if(diccionarioPersona.size() ==0){
            log.info("204: Diccionario de Persona Vacio ");
            return 204;//204 No Content
        }
        Persona personat = diccionarioPersona.get(idPersona);
        if(personat != null){
            int err = personat.añadirMuestra(muestra);
            if(err == 201){
                diccionarioPersona.put(idPersona,personat);
                log.info("201: Muestra añadida a la persona " + personat.getNombrePersona());
                return 201; //OK
            }
            else if(err == 400){
                log.error("400: Bad Format");
                return 400; //error
            }
            else{
                log.error("507:Insufficient storage "+ personat.getNombrePersona());
                return 507;
            }
        }
        else{
            log.error("Muestra Not found");
            return 404; //Muestra NOT FOUND
        }
    }

    @Override
    public List<Muestra> getListaMuestrasProcesadas(String idPersona) {
        List<Muestra> listaMuestrasProcesadas = new LinkedList<>();
        Persona persona = getPersona(idPersona);
        if (persona== null){return null;}
        int Nums = persona.getNumMuestras();
        if (Nums==0){return null;}
        listaMuestrasProcesadas = persona.getListMuestras();
        return listaMuestrasProcesadas;
    }

    @Override
    public int procesarMuestra(Muestra muestra) {

        colaMuestrasPendientes.add(muestra);
        log.info("Nueva mouestra añadida a la cola: ");
        return 1;

    }


    @Override
    public Persona getPersona(String idPersona){
        return diccionarioPersona.get(idPersona);
    }


    @Override
    public void liberarRecursos() {
        this.diccionarioPersona.clear();
        this.listaLaboratorios.clear();
        this.muestrasPersona.clear();
        this.colaMuestrasPendientes.clear();
    }

}
