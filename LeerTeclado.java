import javax.swing.JOptionPane;

public class LeerTeclado {
    public String leerString(String mensaje) {
        return JOptionPane.showInputDialog(null, mensaje);
    }

    public int leerInt(String mensaje) {
        return Integer.parseInt(leerString(mensaje));
    }

    public double leerDouble(String mensaje) {
        return Double.parseDouble(leerString(mensaje));
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public String leerOpcion(String mensaje, String[] opciones) {
        String opcion = null;

        opcion = (String) JOptionPane.showInputDialog(null, mensaje, "Selecciona una opcion", 1, null, opciones,
                opciones[0]);

        return opcion;
    }

    public boolean leerBoolean(String mensaje) {
        String valorTrue = "SI";
        String decision = leerOpcion(mensaje, new String[] { valorTrue, "No" });
        return decision.equals(valorTrue);
    }

    public int menuPrincipal() {
        return leerInt(
                "--------------MENU----------------\n" +
                "0.   Salir\n" +
                "1.-  Buscar por nombre de producto\n" +
                "2.-  Listar por marca\n" +
                "3.-  Listar por presentación\n" +
                "4.-  Listar por precio de menor a mayor\n" +
                "5.-  Listar por precio de mayor a menor\n" +
                "6.-  Listar productos por marca y proveedor\n" +
                "7.-  Listar productos por marca x que tengan precio menor a y\n" +
                "8.-  Listar productos que empiecen con una letra x\n" +
                "9.-  Listar productos que tengan un precio menor a x\n" +
                "10.- Mostrar cuanto dinero hay invertido en los productos\n" +
                "11.- Buscar producto por marca y precio\n" +
                "\nINGRESA UN NUMERO DEL 0 AL 11"
        );
    }
}
