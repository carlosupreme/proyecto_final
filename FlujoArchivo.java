import java.io.*;
import java.util.ArrayList;

public class FlujoArchivo {
    public ArrayList<Producto> generarProductos() {
        ArrayList<String> nombres = new ArrayList<String>();
        ArrayList<String> marcas = new ArrayList<String>();
        ArrayList<String> presentaciones = new ArrayList<String>();
        ArrayList<String> proveedores = new ArrayList<String>();
        ArrayList<Producto> productos = new ArrayList<Producto>();

        try {
            BufferedReader archivoNombres = new BufferedReader(new FileReader("nombres.txt"));
            BufferedReader archivoMarcas = new BufferedReader(new FileReader("marcas.txt"));
            BufferedReader archivoProveedores = new BufferedReader(new FileReader("proveedores.txt"));
            BufferedReader archivoPresentaciones = new BufferedReader(new FileReader("presentaciones.txt"));

            leerArchivo(nombres, archivoNombres, 100);
            leerArchivo(marcas, archivoMarcas, 50);
            leerArchivo(presentaciones, archivoPresentaciones, 227);
            leerArchivo(proveedores, archivoProveedores, 68);

            double precio;
            String nombre, marca, proveedor, presentacion;

            for (int i = 0; i < 1000; i++) {
                precio = Math.floor(Math.random() * (999) + 1);
                nombre = nombres.get((int) Math.floor(Math.random() * (99) + 1));
                marca = marcas.get((int) Math.floor(Math.random() * (49) + 1));
                presentacion = presentaciones.get((int) Math.floor(Math.random() * (226) + 1));
                proveedor = proveedores.get((int) Math.floor(Math.random() * (67) + 1));

                productos.add(new Producto(nombre, marca, presentacion, proveedor, precio));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return productos;
    }

    private void leerArchivo(ArrayList<String> vector, BufferedReader buferReader, int length) throws Exception {
        for (int i = 0; i < length; i++) {
            vector.add(buferReader.readLine());
        }
        buferReader.close();
    }

}
