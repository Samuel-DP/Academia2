import java.util.ArrayList;

public class Academia {

    public ArrayList<Estudiante> estudiantes = new ArrayList<>();
    public ArrayList<Curso> cursos = new ArrayList<>();
    public ArrayList<Matricula> matriculas = new ArrayList<>();

    public Academia(){
        this.estudiantes = CSV.cargarEstudiante();
        this.cursos = CSV.cargarCurso();
        this.matriculas = CSV.cargarMatricula();
    }

    public boolean añadirEstudiante(Estudiante estudiante){
        for(Estudiante es: this.estudiantes){
            if(es.getDni().equalsIgnoreCase(estudiante.getDni())){
                return false;
            }
        }
        this.estudiantes.add(estudiante);
        CSV.guardarEstudiante(estudiante);
        return true;
    }

    public boolean añadirCurso(Curso curso){
        for(Curso c : cursos){
            if(c.getId().equalsIgnoreCase(curso.getId())){
                return false;
            }
        }
        this.cursos.add(curso);
        CSV.guardarCurso(curso);
        return true;
    }

    public boolean existeDni(String dni){
        for(Estudiante es : this.estudiantes){
            if(es.getDni().equalsIgnoreCase(dni)){
                return true;
            }
        }
        return false;
    }

    public boolean existeCurso(String nombreCurso){
        for(Curso c : this.cursos){
            if(c.getNombre().equalsIgnoreCase(nombreCurso)){
                return true;
            }
        }
        return false;
    }

    public boolean matricular(Matricula matricula){
        for(Matricula m : this.matriculas){
            if(m.getDniEstud().equalsIgnoreCase(matricula.getDniEstud()) && m.getnombreCurso().equalsIgnoreCase(matricula.getnombreCurso())){
                return false;
            }
        }
        this.matriculas.add(matricula);
        CSV.guardarMatricula(matricula);
        return true;
    }

    public ArrayList<Curso> mostrarCursos(){
        return this.cursos;
    }

    public ArrayList<Estudiante> mostrarEstudiantes(){
        return this.estudiantes;
    }

    public ArrayList<Matricula> mostrarMatriculas(){
        return this.matriculas;
    }
    
}
