public class Producto {
    private String nombre;
    private String marca;
    private String presentacion;
    private String proveedor;
    private double precio;

    public Producto(String nombre, String marca, String presentacion, String proveedor, double precio) {
        this.nombre = nombre;
        this.marca = marca;
        this.presentacion = presentacion;
        this.proveedor = proveedor;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return nombre + " | marca: " + marca + " | precio: $" + precio + " | proveedor: " + proveedor + " | presentacion: " + presentacion;
    }
}
