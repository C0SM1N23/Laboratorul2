import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ManagerCursuri {
    private Curs[] cursuri;
    Profesor[] profesori;

    public ManagerCursuri() {
        cursuri = new Curs[0];
        profesori = new Profesor[0];
    }

    public void AddCurs(Curs curs) {
        int noualungime = cursuri.length + 1;
        Curs[] aux = new Curs[noualungime];
        System.arraycopy(cursuri, 0, aux, 0, cursuri.length);
        aux[cursuri.length] = curs;
        this.cursuri = aux;
    }


    public void ModificaCurs(String numeCurs, Curs cursNou) {
        for (int i = 0; i < cursuri.length; i++) {
            if (cursuri[i].nume.equals(numeCurs)) {
                cursuri[i] = cursNou;
                break;
            }
        }
    }
    public void DeleteCurs(String numeCurs) {
        int index = -1;
        for (int i = 0; i < cursuri.length; i++) {
            if (cursuri[i].nume.equals(numeCurs)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            Curs[] auxCursuri = new Curs[cursuri.length - 1];

            for (int i = 0, j = 0; i < cursuri.length; i++) {
                if (i != index) {
                    auxCursuri[j] = cursuri[i];
                    j++;
                }
            }
            this.cursuri = auxCursuri;

        }
    }
    public void AfiseazaProfesori() {
        if (profesori.length == 0) {
            System.out.println("Nu există profesori în listă.");
        } else {
            System.out.println("Lista profesorilor:");
            for (Profesor profesor : profesori) {
                System.out.println("Profesor: " + profesor.getNume() + " " + profesor.getPrenume() + ", ID: " + profesor.getId());
            }
        }
    }

    public void AdaugaProfesor(Profesor profesor) {
        Profesor[] aux = new Profesor[profesori.length + 1];
        System.arraycopy(profesori, 0, aux, 0, profesori.length);
        aux[profesori.length] = profesor;
        profesori = aux; // Alocare corectă a noii liste de profesori
    }

    public void StergeProfesor(String idProfesor) {
        int index = -1;
        for (int i = 0; i < profesori.length; i++) {
            if (profesori[i].getId().equals(idProfesor)) {
                index = i;
                break;
            }
        }

        if (index != -1) { // Verificare pentru a evita eroarea
            Profesor[] aux = new Profesor[profesori.length - 1];
            for (int i = 0, j = 0; i < profesori.length; i++) {
                if (i != index) {
                    aux[j++] = profesori[i];
                }
            }
            profesori = aux; // Alocare a noii liste de profesori
        }
    }

    public void AdaugaStudentLaCurs(String numeCurs, Student studentNou) {
        for (Curs curs : cursuri) {
            if (curs.nume.equals(numeCurs)) {
                curs.AddStudent(studentNou);
                break;
            }
        }
    }
    public  void UpdateStudent(Student student)
    {


    }

    public void StergeStudentDeLaCurs(String numeCurs, String numeStudent) {
        for (Curs curs : cursuri) {
            if (curs.nume.equals(numeCurs)) {
                curs.RemoveStudent(numeStudent);
                break;
            }
        }
    }

    public void ModificaProfesorLaCurs(String numeCurs, Profesor profesorNou) {
        for (Curs curs : cursuri) {
            if (curs.nume.equals(numeCurs)) {
                curs.UpdateProfesor(profesorNou);
                break;
            }
        }
    }

    public void RaporteazaStudentiLaCurs(String numeCurs) {
        for (Curs curs : cursuri) {
            if (curs.nume.equals(numeCurs)) {
                curs.raporteazaNoteCurs();
                break;
            }
        }
    }

    public void AfiseazaCursuriLaConsola() {
        for (Curs c : cursuri) {
            System.out.println(c);
        }
    }

    public void RaporteazaNoteleStudentilorLaCurs(String numeCurs) {
        for (Curs curs : cursuri) {
            if (curs.nume.equals(numeCurs)) {
                curs.raporteazaNoteCurs();
                break;
            }
        }
    }

    public double RaporteazaMediaStudentilorLaCurs(String numeCurs) {
        for (Curs curs : cursuri) {
            if (curs.nume.equals(numeCurs)) {
                return curs.calculeazaMedia();
            }
        }
        return 0.0; // Dacă cursul nu a fost găsit
    }

    public double RaporteazaMediaNotelorDateDeProfesor(Profesor profesor) {
        double suma = 0.0;
        int numarNote = 0;

        for (Curs curs : cursuri) {
            if (curs.profesor.equals(profesor)) {
                double media = curs.calculeazaMedia();
                suma += media;
                numarNote++;
            }
        }

        return numarNote == 0 ? 0.0 : suma / numarNote;
    }
}
