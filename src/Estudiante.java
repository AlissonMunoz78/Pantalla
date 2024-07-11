public class Estudiante {
    private String nombre;
    private String cedula;
    private int edad;

    public Estudiante(String nombre, String cedula, int edad) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public int getEdad() {
        return edad;
    }
}
