package ar.edu.unlam.cuentas.personas;

public class Banco {
    private String nombre;
    private Integer cuit;
    private 
    Banco(String nombre,Integer cuit){

        this.nombre=nombre;
        this.cuit=cuit;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getNombre(){
        return this.nombre;
    }
    public void setCuit(Integer cuit ){
        this.cuit= cuit;
    }
    public Integer getCuit(){
        return this.cuit;
    }


}
