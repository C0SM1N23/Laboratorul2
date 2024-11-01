

public class Clase {
    public static void main(String[] args) {
//definire studenti

//definire profesor
        Profesor prof = new Profesor("Anton","Panaitescu", "P00");
//definire curs nou




//adaugare curs in lista de cursuri
        ManagerCursuri cursuri = new ManagerCursuri();

        cursuri.AfiseazaCursuriLaConsola();

        Student student1 = new Student("Andrei", "Negoita", 2231);
        Student student2 = new Student("Ion", "Mateescu", 4221);
        Student student3 = new Student("Elena", "Vasilescu", 3355);
        Student[] studenti = new Student[]{student1, student2, student3};
        Curs curs = new Curs("Rezistenta Materialelor", "calculul reacţiunilor,\n" +"diagramele de eforturi, calculul caracteristicilor geometrice ale\n" + "suprafeţelor plane şi calculul elementelor de rezistenţă la solicitări simple\n" , prof, studenti);
        cursuri.AddCurs(curs);
        Profesor prof1 = new Profesor("Anton", "Panaitescu", "P01");
        Profesor prof2 = new Profesor("Maria", "Ionescu", "P02");

        // Definire curs nou
        Curs curs2 = new Curs("Rezistenta Materialelor",
                "Calculul reacțiunilor și diagramele de eforturi",
                prof1, studenti);

        // Creare manager de cursuri
        ManagerCursuri managerCursuri = new ManagerCursuri();

        // Adăugare curs și afișare cursuri
        managerCursuri.AddCurs(curs2);
        System.out.println("Cursuri după adăugare:");
        managerCursuri.AfiseazaCursuriLaConsola();

        // Modificare descriere curs
        curs2.modificaDescriere("Noul subiect de studiu");
        System.out.println("\nCurs după modificarea descrierii:");
        managerCursuri.AfiseazaCursuriLaConsola();

        // Adăugare profesor nou
        managerCursuri.AdaugaProfesor(prof1);
        managerCursuri.AdaugaProfesor(prof2);
        System.out.println("Profesori după adăugare:");

        for (int i = 0; i < managerCursuri.profesori.length; i++) {
            Profesor p = managerCursuri.profesori[i];
            if (p != null) {
                System.out.println("Nume: " + p.getNume() + ", Prenume: " + p.getPrenume() + ", ID: " + p.getId());
            }

        // Adăugare student la curs
        managerCursuri.AdaugaStudentLaCurs("Rezistenta Materialelor", student3);
        System.out.println("\nStudenți după adăugarea unui nou student:");
        managerCursuri.RaporteazaStudentiLaCurs("Rezistenta Materialelor");

        // Notare studenți
        curs.noteazaStudent(0, 9.5);
        curs.noteazaStudent(1, 8.0);
        System.out.println("\nNotele studenților:");
        managerCursuri.RaporteazaNoteleStudentilorLaCurs("Rezistenta Materialelor");

        // Calcularea mediei notelor date de un profesor
        double mediaProfesor = managerCursuri.RaporteazaMediaNotelorDateDeProfesor(prof1);
        System.out.println("\nMedia notelor date de profesorul Anton Panaitescu: " + mediaProfesor);

        // Ștergere student de la curs
        managerCursuri.StergeStudentDeLaCurs("Rezistenta Materialelor", "Ion Mateescu");
        System.out.println("\nStudenți după ștergerea lui Ion Mateescu:");
        managerCursuri.RaporteazaStudentiLaCurs("Rezistenta Materialelor");

        // Modificare profesor la curs
        managerCursuri.ModificaProfesorLaCurs("Rezistenta Materialelor", prof2);
        System.out.println("\nCurs după modificarea profesorului:");
        managerCursuri.AfiseazaCursuriLaConsola();

        // Ștergere profesor
        managerCursuri.StergeProfesor("P01");
        System.out.println("\nProfesori după ștergerea lui Anton Panaitescu:");

        managerCursuri.AfiseazaProfesori();
    }
}}