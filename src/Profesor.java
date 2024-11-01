public class Profesor extends Persoana {
    String id;


    public Profesor(String nume, String prenume, String id)
    {
        super(nume,prenume);
        this.id = id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getNume() {
        return nume;
    }
    public String getId() {
        return id;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }
    @Override
    public String toString() {
        return "Profesor{" + "nume=" + nume + ", prenume=" + prenume + '}';
    }
}