
import java.time.LocalDate;

public class Matricula {

    private String dniEstud;
    private String nombreCurso;
    private LocalDate fecha;

    public Matricula(String dniEstud, String nombreCurso, LocalDate fecha){
        this.dniEstud = dniEstud;
        this.nombreCurso = nombreCurso;
        this.fecha = fecha;
    }

    public String getDniEstud(){ return dniEstud; }
    public String getnombreCurso(){ return nombreCurso; }
    public LocalDate getfecha(){ return fecha; }

    public String toFichero(){
        return dniEstud+";"+nombreCurso+";"+fecha;
    }

    @Override
    public String toString(){
        return "DNI: "+dniEstud+ "Curso: "+nombreCurso + "Fecha: "+fecha;
    }
    
}
