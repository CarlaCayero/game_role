package gameClasses;

import javax.swing.*;

/**
 * Clase que representa a un personaje de tipo Guerrero en el juego.
 * Extiende la clase abstracta Personaje.
 */
public class Guerrero extends Personaje{

    /**
     * Constructor de la clase Guerrero.
     * @param nombre Nombre del guerrero.
     */
    public Guerrero(String nombre) {
        super(nombre,5, 0, 3);
        this.GIF_ABAJO = new ImageIcon("src/images/guerrero/warrior_down.gif");
        this.GIF_ARRIBA = new ImageIcon("src/images/guerrero/warrior_up.gif");
        this.GIF_DERECHA = new ImageIcon("src/images/guerrero/warrior_right.gif");
        this.GIF_IZQUIERDA = new ImageIcon("src/images/guerrero/warrior_left.gif");
    }


    // ----------------------------------------------------- Métodos --------------------------------------------------------------------


    /**
     * Método que solicita al usuario ingresar el nombre del personaje.
     * @return true si se ingresó un nombre válido, false de lo contrario.
     */
    public boolean pedirNombre() {
        boolean nombreValido = false;
        boolean comprobar = true;

        while (!nombreValido) {
            ImageIcon icon = new ImageIcon("src/images/guerrero/warrior_down.gif");
            // Se muestra un cuadro de diálogo para que el usuario ingrese el nombre del personaje.
            String nombre = (String) JOptionPane.showInputDialog(null, "Introduce el nombre del Guerrero: ", "Necesito un nombre", JOptionPane.INFORMATION_MESSAGE, icon, null, null);

            // Si se ingresó un nombre.
            if (nombre != null) {
                // Si el nombre no está vacío.
                if (!nombre.isEmpty()) {
                    setNombre(nombre);
                    nombreValido = true;
                } else {
                    // Se muestra un mensaje de error si el nombre está vacío.
                    JOptionPane.showMessageDialog(null, "Debes ingresar un nombre válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // Si el usuario cancela la operación se muestra un mensaje de confirmación para elegir otro personaje.
                int opcion = JOptionPane.showConfirmDialog(null, "¿Deseas elegir otro personaje?", "Cancelar", JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.YES_OPTION){
                    nombreValido =  true;
                    comprobar = false;
                }
            }
        }
        // Si se elige elegir otro personaje pero se cancela, se devuelve false para indicar que el nombre no es válido.
        if(comprobar == false){
            nombreValido= false;
        }
        return nombreValido;
    }


}
