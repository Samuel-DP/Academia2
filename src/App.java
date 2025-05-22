import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Academia academia = new Academia();
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do { 
            System.out.println("Bienvenido a la Academia");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Crear curso");
            System.out.println("3. Matricular a un estudiante en un curso");
            System.out.println("4. Mostrar cursos");
            System.out.println("5. Mostrar estudiantes");
            System.out.println("6. Mostrar matriculas");
            System.out.println("7. Salir");
            System.out.println("Seleccione una opcion");   

            while(!sc.hasNextInt()){
                System.out.println("Inserte un nº entero:  ");
                sc.next();
            }
            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion){
                case 1 -> añadirEstudiante(academia, sc);
                case 2 -> añadirCurso(academia, sc);
                case 3 -> matricular(academia, sc);
                case 4 -> mostrarCursos(academia);
                case 5 -> mostrarEstudiantes(academia);
                case 6 -> mostrarMatriculas(academia);
                case 7 -> System.out.println("Saliendo...");
                default -> System.out.println("Opcion no valida, intentelo de nuevo");
            }
        } while (opcion != 7);
    }

    public static void añadirEstudiante(Academia academia, Scanner sc){
        System.out.println("Nombre: ");
        String nombre = sc.nextLine().trim();
        System.out.println("Apellido: ");
        String apellido = sc.nextLine().trim();
        System.out.println("DNI: ");
        String dni = sc.nextLine().trim();

        if(nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty()){
            System.out.println("No se pueden dejar espacios en  blanco");
            return;
        }

        Estudiante estudiante = new Estudiante(nombre, apellido, dni);
        boolean añadido = academia.añadirEstudiante(estudiante);

        if(añadido){
            System.out.println("Estudiante añadido con exito");
        }else{
            System.out.println("Ya esta registrado este estudiante");
        }
    }

    public static void añadirCurso(Academia academia, Scanner sc){
        System.out.println("ID: ");
        String id = sc.nextLine().trim();
        System.out.println("Nombre:");
        String nombre = sc.nextLine().trim();
        System.out.println("Duracion (h): ");
        String duracionStrign = sc.nextLine().trim();

        if(id.isEmpty() || nombre.isEmpty() || duracionStrign.isEmpty()){
            System.out.println("No se pueden dejar espacios en  blanco");
            return;
        }

        int duracion = 0;
        try {
            duracion = Integer.parseInt(duracionStrign);
        } catch (NumberFormatException e) {
        }

        Curso curso = new Curso(id, nombre, duracion);
        boolean añadido = academia.añadirCurso(curso);

        if(añadido){
            System.out.println("Curso añadido con exito");
        }else{
            System.out.println("Ya esta registrado este curso");
        }
    }

    public static void matricular(Academia academia, Scanner sc){
        System.out.println("DNI estudiante: ");
        String dniEst = sc.nextLine().trim();

        boolean existeDni = academia.existeDni(dniEst);

        if(existeDni){
            System.out.println("Nombre curso: ");
            String nombreCurso = sc.nextLine().trim();
            boolean existeCurso = academia.existeCurso(nombreCurso);
            if(existeCurso){
                Matricula matricula = new Matricula(dniEst, nombreCurso, LocalDate.now());
                boolean matriculado = academia.matricular(matricula);
                if(matriculado){
                    System.out.println("Alumno matriculado con exito");
                }else{
                    System.out.println("Error el alumno ya se encuentra matriculado en este curso");
                }
            }else{
                System.out.println("No existe ningun curso con ese nombre");
            }
        }else{
            System.out.println("No hay ningun alumno registrado con ese DNI");
        }
    }

    public static void mostrarCursos(Academia academia){
        ArrayList<Curso> cursos = academia.mostrarCursos();
        if(cursos.isEmpty()){
            System.out.println("No hay ningun curso en este momento");
        }else{
            for(Curso c : cursos){
                System.out.println(c);
            }    
        }
    }

    public static void mostrarEstudiantes(Academia academia){
        ArrayList<Estudiante> estudiantes = academia.mostrarEstudiantes();
        if(estudiantes.isEmpty()){
            System.out.println("No hay ningun estudiante");
        }else{
            for(Estudiante es : estudiantes){
                System.out.println(es);
            }
        }
    }

    public static void mostrarMatriculas(Academia academia){
        ArrayList<Matricula> matriculas = academia.mostrarMatriculas();
        if(matriculas.isEmpty()){
            System.out.println("No hay matriculas registradas en este momento");
        }else{
            for(Matricula m : matriculas){
                System.out.println(m);
            }
        }
    }

}
