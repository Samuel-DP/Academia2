public class Curso {

    private String id;
    private String nombre;
    private int duracion;

    public Curso(String id, String nombre, int duracion){
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
    }

    public String getId(){return id; }
    public String getNombre(){return nombre; }
    public int getDuracion(){return duracion; }

    public String toFichero(){
        return id+";"+nombre+";"+duracion;
    }

    @Override
    public String toString(){
        return "ID Curso: "+id+" Nombre: "+nombre+" Duracion: "+duracion;
    }
    
}
