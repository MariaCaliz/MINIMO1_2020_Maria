package edu.upc.eetac.dsa;
import edu.upc.eetac.dsa.clases.*;

import java.util.List;

public interface Covid19Manager {

    int añadirPersona(String idPersona, String nombrePersona, String apellidos, int edad, String salud);


    int añadirMuestraPersona(String idPersona, Muestra muestra, Laboratorio laboratorio);

    int procesarMuestra(Muestra muestra);

    List<Muestra> getListaMuestrasProcesadas(String idPersona);

    Persona getPersona(String idPersona);


    void liberarRecursos();



}
