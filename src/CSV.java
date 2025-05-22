import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class CSV {

    public static String FICHEROESTUD = "estudiantes.txt";
    public static String FICHEROCURSOS = "cursos.txt";
    public static String FICHEROMATRI = "matriculas.txt";

    public static void guardarEstudiante(Estudiante estudiante){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FICHEROESTUD, true))) {
            writer.write(estudiante.toFichero());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar estudiantes" + e.getMessage());
        }
    }

    public static ArrayList<Estudiante> cargarEstudiante(){
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(FICHEROESTUD))) {
            String contenido;
            while((contenido = reader.readLine()) != null){
                String[]separar = contenido.split(";");
                if(separar.length == 3){
                    String nombre = separar[0];
                    String apellido = separar[1];
                    String dni = separar[2];
                    Estudiante estudiante = new Estudiante(nombre, apellido, dni);
                    estudiantes.add(estudiante);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar estudiantes" + e.getMessage());
        }
        return estudiantes;
    }

        public static void guardarCurso(Curso curso){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FICHEROESTUD, true))) {
            writer.write(curso.toFichero());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar estudiantes" + e.getMessage());
        }
    }

    public static ArrayList<Curso> cargarCurso(){
        ArrayList<Curso> cursos = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(FICHEROESTUD))) {
            String contenido;
            while((contenido = reader.readLine()) != null){
                String[]separar = contenido.split(";");
                if(separar.length == 3){
                    String id = separar[0];
                    String nombre = separar[1];
                    int duracion = Integer.parseInt(separar[2]);
                    Curso curso = new Curso(id, nombre, duracion);
                    cursos.add(curso);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar estudiantes" + e.getMessage());
        }
        return cursos;
    }

    public static void guardarMatricula(Matricula matriculas){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FICHEROMATRI))) {
            writer.write(matriculas.toFichero());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar matriculas");
        }
    }

    public static ArrayList<Matricula> cargarMatricula(){
        ArrayList<Matricula> matriculas = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(FICHEROMATRI))) {
            String contenido;
            while((contenido = reader.readLine()) != null){
                String []separar = contenido.split(";");
                if(separar.length == 3){
                    String dniEstud = separar[0];
                    String nombreCurso = separar[1];
                    LocalDate fecha = LocalDate.parse(separar[2]);
                    Matricula matricula = new Matricula(dniEstud, nombreCurso, fecha);
                    matriculas.add(matricula);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar matriculas");
        }
        return matriculas;
    }
}
