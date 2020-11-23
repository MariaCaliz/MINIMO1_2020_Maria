package edu.upc.eetac.dsa.clases;
import java.util.LinkedList;
import java.util.List;


public class Persona {

    String idPersona;
    String nombrePersona;
    String apellidos;
    int edad;
    String salud;
    List<Muestra> listMuestras = null;

    public Persona(){

    }

    public Persona(String idPersona, String nombrePersona, String apellidos,int edad, String salud){
        this.idPersona = idPersona;
        this.nombrePersona =nombrePersona;
        this.apellidos = apellidos;
        this.edad = edad;
        this.salud = salud;

    }
    public int añadirMuestra(Muestra muestra){
        try{
            this.listMuestras.add(muestra);
        }
        catch (ExceptionInInitializerError e)
        {
            return 400;//400 error
        }
        catch (IndexOutOfBoundsException e){
            return 507;//no storage
        }
        return 201;//201 ok
    }

    public int getNumMuestras(){
        return this.listMuestras.size();
    }

    public String getNombrePersona(){ return nombrePersona;}
    public void setNombrePersona(String nombrePersona){this.nombrePersona= nombrePersona;}
    public String getApellidos(){return apellidos;}
    public void setApellidos(String apellidos){this.apellidos= apellidos;}
    public String getIdPersona(){return idPersona;}
    public void setIdPersona(String idPersona){this.idPersona= idPersona;}
    public int getEdad(){return edad;}
    public void setEdad(int edad){this.edad= edad;}
    public String getSalud(){return salud;}
    public void setSalud(String salud){this.salud= salud;}
    public List<Muestra> getListMuestras(){return this.listMuestras;}
    public void setListMuestras(List<Muestra> listMuestras){this.listMuestras= listMuestras;}





}
