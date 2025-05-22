public class Estudiante {

    private String nombre;
    private String apellido;
    private String dni;

    public Estudiante(String nombre, String apellido, String dni){
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public String getNombre(){return nombre; }
    public String getApellido(){return apellido; }
    public String getDni(){return dni; }

    public String toFichero(){
        return nombre+";"+apellido+";"+dni;
    }

    @Override
    public String toString(){
        return "Nombre: "+ nombre+ "Apellido: "+apellido+"DNI: "+dni;
    }
    
}
