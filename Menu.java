import java.util.ArrayList;

public class Menu {
    private LeerTeclado lector;

    public Menu() {
        lector = new LeerTeclado();
    }

    public static void main(String[] args) {
        FlujoArchivo flujo = new FlujoArchivo();
        Lista lista = new Lista(flujo.generarProductos());
        Menu menu = new Menu();
        menu.lector.mostrarMensaje("Se han añadido 1000 productos aleatoriamente");
        int opcion = -1;
        while (opcion != 0) {
            try {
                opcion = menu.lector.menuPrincipal();
                if (opcion < 0 || opcion > 11)
                    throw new Exception();

                menu.ejecutarOpcion(opcion, lista);

            } catch (Exception e) {
                menu.lector.mostrarMensaje("Ingresa un numero entero entre 0-11");
            }
        }
    }

    private void ejecutarOpcion(int opcion, Lista lista) {
        String mensaje = "Hasta luego";

        switch (opcion) {
            case 1:
                mensaje = buscarPorCriterio(lista, "nombre");
                break;
            case 2:
                mensaje = buscarPorCriterio(lista, "marca");
                break;
            case 3:
                mensaje = buscarPorCriterio(lista, "presentacion");
                break;
            case 4:
                mensaje = lista.ordenarPrecio("asc");
                break;
            case 5:
                mensaje = lista.ordenarPrecio("desc");
                break;
            case 6:
                mensaje = filtrarPorMarcaYProveedor(lista);
                break;
            case 7:
                mensaje = filtrarPorMarcaYPrecio(lista);
                break;
            case 8:
                mensaje = prodsEmpiecenCon(lista);
                break;
            case 9:
                mensaje = precioMenor(lista);
                break;
            case 10:
                mensaje = "El inventario vale $" + lista.valor();
                break;
            case 11:
                mensaje = buscarMarcaYPrecio(lista);
                break;
        }

        if (mensaje == "")
            mensaje = "No hay ningun producto con ese criterio de busqueda";

        lector.mostrarMensaje(mensaje);
    }

    private String buscarMarcaYPrecio(Lista lista) {
        ArrayList<Producto> filtrados;
        boolean pedirMarca = true, pedirPrecio = true;
        String marca = "", productos = "";
        double precio = 0.0;

        while (pedirMarca) {
            try {
                marca = lector.leerString("Marca a buscar");
                if (marca.isBlank() || marca.isEmpty())
                    throw new Exception();

                pedirMarca = false;
            } catch (Exception e) {
                lector.mostrarMensaje("Ingresa una marca valida");
            }
        }

        while (pedirPrecio) {
            try {
                precio = lector.leerDouble("Ingresa un precio a buscar");
                if (precio < 0)
                    throw new Exception();

                pedirPrecio = false;
            } catch (Exception e) {
                lector.mostrarMensaje("Ingresa un precio valido");
            }
        }

        filtrados = lista.buscarPorMarcaYCriterio2(marca, "precio", String.valueOf(precio));

        for (int i = 0; i < filtrados.size(); i++) {
            productos += (Producto) filtrados.get(i) + "\n";
        }

        return productos;
    }

    private String precioMenor(Lista lista) {
        return null;
    }

    private String prodsEmpiecenCon(Lista lista) {
        return null;
    }

    private String filtrarPorMarcaYPrecio(Lista lista) {
        return null;
    }

    private String filtrarPorMarcaYProveedor(Lista lista) {
        return null;
    }

    private String buscarPorCriterio(Lista lista, String aBuscar) {
        boolean continua = true;
        String criterio = "";
        String filtrados = "";
        ArrayList<Producto> prods = null;

        while (continua) {
            try {
                criterio = lector.leerString("Nombre del producto");
                if (criterio.isBlank() || criterio.isEmpty())
                    throw new Exception();

                switch (aBuscar) {
                    case "nombre":
                        prods = lista.buscarNombre(criterio);
                        break;
                    case "marca":
                        prods = lista.buscarMarca(criterio);
                        break;
                    case "presentacion":
                        prods = lista.buscarPresentacion(criterio);
                        break;
                }

                if (prods.size() >= 1) {
                    filtrados = "Hay " + prods.size() + " productos con el nombre " + criterio + "\n";
                    for (int i = 0; i < prods.size(); i++) {
                        filtrados += (Producto) prods.get(i) + "\n";
                    }
                }

                continua = false;
            } catch (Exception e) {
                lector.mostrarMensaje("Ingresa un nombre de producto");
            }
        }

        return filtrados;
    }
}
