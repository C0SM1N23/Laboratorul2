//implements OperatiiCurs
public class Curs  {
    String nume;
    String descriere;
    Profesor profesor;
    Student[] studenti;
    double[] note;

    public Curs(String nume, String descriere, Profesor profesor, Student[] studenti) {
        this.nume = nume;
        this.descriere = descriere;
        this.profesor = profesor;
        this.studenti = studenti;
        this.note = new double[studenti.length];
    }

    public void modificaDescriere(String descriereNoua) {
        this.descriere = descriereNoua;
    }

    public void AddStudent(Student studentNou) {
        Student[] auxStudenti = new Student[studenti.length + 1];
        double[] auxNote = new double[note.length + 1];
        System.arraycopy(studenti, 0, auxStudenti, 0, studenti.length);
        System.arraycopy(note, 0, auxNote, 0, note.length);
        auxStudenti[studenti.length] = studentNou;
        studenti = auxStudenti;
        note = auxNote;
    }

    public void RemoveStudent(Student student) {
        int index = -1;
        String numeStudent = student.getNume();
        for (int i = 0; i < studenti.length; i++) {
            if (studenti[i].nume.equals(numeStudent)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            Student[] auxStudenti = new Student[studenti.length - 1];
            double[] auxNote = new double[note.length - 1];
            for (int i = 0, j = 0; i < studenti.length; i++) {
                if (i != index) {
                    auxStudenti[j] = studenti[i];
                    auxNote[j] = note[i];
                    j++;
                }
            }
            studenti = auxStudenti;
            note = auxNote;
        }
    }

    public void noteazaStudent(int indexStudent, double nota) {
        if (indexStudent >= 0 && indexStudent < note.length) {
            note[indexStudent] = nota;
        }
    }

    public double calculeazaMedia() {
        double suma = 0.0;
        int numarNote = 0;
        for (double nota : note) {
            if (nota > 0) {
                suma += nota;
                numarNote++;
            }
        }
        return numarNote == 0 ? 0.0 : suma / numarNote;
    }
    public void UpdateProfesor(Profesor profesorNou) {
        this.profesor = profesorNou;
    }
    //public void UpdateStudent(Student studentNou){this.studenti = studentNou}

    public void raporteazaNoteCurs() {
        System.out.println("Raport de note pentru cursul: " + nume);
        for (int i = 0; i < studenti.length; i++) {
            if (note[i] > 0) {
                System.out.printf("Student: %s %s, Nota: %.2f%n", studenti[i].nume, studenti[i].prenume, note[i]);
            }
        }
    }

    @Override
    public String toString() {
        return "Curs{" + "nume='" + nume + '\'' + ", descriere='" + descriere + '\'' +
                ", profesor=" + profesor + '}';
    }
}

