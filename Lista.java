import java.util.ArrayList;

public class Lista {
    private ArrayList<Producto> productos;

    public Lista(ArrayList<Producto> prods) {
        productos = prods;
    }

    public Lista() {
        productos = new ArrayList<Producto>();
    }

    public ArrayList<Producto> buscarNombre(String nombre) {
        ArrayList<Producto> filtrados = new ArrayList<Producto>();

        for (int i = 0; i < productos.size(); i++) {
            Producto producto = (Producto) productos.get(i);
            if (producto.getNombre().toLowerCase().equals(nombre.toLowerCase()))
                filtrados.add(producto);
        }

        return filtrados;
    }

    public ArrayList<Producto> buscarMarca(String marca) {
        ArrayList<Producto> filtrados = new ArrayList<Producto>();

        for (int i = 0; i < productos.size(); i++) {
            Producto producto = (Producto) productos.get(i);
            if (producto.getMarca().toLowerCase().equals(marca.toLowerCase()))
                filtrados.add(producto);
        }

        return filtrados;
    }

    public ArrayList<Producto> buscarPresentacion(String presentacion) {
        ArrayList<Producto> filtrados = new ArrayList<Producto>();

        for (int i = 0; i < productos.size(); i++) {
            Producto producto = (Producto) productos.get(i);
            if (producto.getPresentacion().toLowerCase().equals(presentacion.toLowerCase()))
                filtrados.add(producto);
        }

        return filtrados;
    }

    public String ordenarPrecio(String ordenarPor) {
        ArrayList<Producto> filtrados = new ArrayList<Producto>();
        String ordenados = "";

        for (int i = 0; i < productos.size(); i++) {
            Producto producto = (Producto) productos.get(i);
            switch (ordenarPor) {
                case "asc":

                    break;

                case "desc":
                    break;
            }
        }

        return ordenados;
    }

    public ArrayList<Producto> buscarPorMarcaYCriterio2(String marca, String criterio2, String valorCriterio2) {
        ArrayList<Producto> filtrados = new ArrayList<Producto>();

        for (int i = 0; i < productos.size(); i++) {
            Producto producto = (Producto) productos.get(i);
            switch (criterio2) {
                case "proveedor":
                    if (producto.getMarca().toLowerCase().equals(marca.toLowerCase()) &&
                            producto.getProveedor().toLowerCase().equals(valorCriterio2.toLowerCase()))
                        filtrados.add(producto);
                    break;

                case "precio":
                    if (producto.getMarca().toLowerCase().equals(marca.toLowerCase()) &&
                            producto.getPrecio() == Double.parseDouble(valorCriterio2))
                        filtrados.add(producto);
                    break;
            }
        }

        return filtrados;
    }

    public double valor() {
        double resultado = 0.0;

        for (int i = 0; i < productos.size(); i++) {
            resultado += ((Producto) productos.get(i)).getPrecio();
        }

        return (int) Math.round(resultado);
    }
}