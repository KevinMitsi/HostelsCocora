package com.example.hostelscocora.Persistencia;

import com.example.hostelscocora.Model.Empleado;
import com.example.hostelscocora.Model.Hostal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Persistencia {
    public static final String RUTA_ARCHIVO_EMPLEADOS = "C:\\Users\\Kevin\\Documents\\GitHub\\HostelsCocora\\src\\main\\java\\com\\example\\hostelscocora\\archivos\\archivoEmpleados.txt";
    public static final String RUTA_ARCHIVO_CLIENTES = "C:\\Users\\Kevin\\Documents\\GitHub\\HostelsCocora\\src\\main\\java\\com\\example\\hostelscocora\\archivos\\archivoCuentas.txt";
    public static final String RUTA_ARCHIVO_RESERVAS_ = "C:\\Users\\Kevin\\Documents\\GitHub\\HostelsCocora\\src\\main\\java\\com\\example\\hostelscocora\\archivos\\archivoReseras.txt";
    public static final String RUTA_ARCHIVO_LOG = "C:\\Users\\Kevin\\Documents\\GitHub\\HostelsCocora\\src\\main\\java\\com\\example\\hostelscocora\\archivos\\SnowaloweLog.txt";
    public static final String RUTA_ARCHIVO_MODELO_HOTAL_BINARIO = "C:\\Users\\Kevin\\Documents\\GitHub\\HostelsCocora\\src\\main\\java\\com\\example\\hostelscocora\\archivos\\model.dat";
    public static final String RUTA_ARCHIVO_MODELO_HOSTAL_XML = "C:\\Users\\Kevin\\Documents\\GitHub\\HostelsCocora\\src\\main\\java\\com\\example\\hostelscocora\\archivos\\model.xml";









    /**
     * Guarda en un archivo de texto todos la informaci�n de las personas almacenadas en el ArrayList

     * @throws IOException
     */



    public static void guardarEmpleados(ArrayList<Empleado> listaEmpleados) throws IOException {

        // TODO Auto-generated method stub
        String contenido = "";

        for(Empleado empleado:listaEmpleados)
        {
            contenido+= empleado.getNombre()+","+empleado.getCedula()+","+"\n";
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_EMPLEADOS, contenido, false);
    }

    /*



    public static void guardarCuentas(ArrayList<Cuenta> listaCuentas) throws IOException {

        // TODO Auto-generated method stub
        String contenido = "";

        for(Cuenta cuenta:listaCuentas)
        {
            contenido+= cuenta.getUsuario()+ ","+ cuenta.getContrasenia()+ "\n";
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_CUENTA, contenido, false);
    }


    private static boolean validarUsuario(String usuario, String contrasenia) throws FileNotFoundException, IOException
    {
        ArrayList<Cuenta> usuarios = Persistencia.cargarCuentas(RUTA_ARCHIVO_CUENTA);

        for (Cuenta cuentaAux : usuarios) {
            if (cuentaAux.getUsuario().equalsIgnoreCase(usuario) && cuentaAux.getContrasenia().equalsIgnoreCase(contrasenia)) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Cuenta> cargarCuentas(String ruta) throws FileNotFoundException, IOException {
        ArrayList<Cuenta> usuarios =new ArrayList<Cuenta>();

        ArrayList<String> contenido = ArchivoUtil.leerArchivo(ruta);
        String linea="";

        for (int i = 0; i < contenido.size(); i++) {
            linea = contenido.get(i);

            Cuenta usuario = new Cuenta();
            usuario.setUsuario(linea.split(",")[0]);
            usuario.setContrasenia(linea.split(",")[1]);

            usuarios.add(usuario);
        }
        return usuarios;
    }



//	----------------------LOADS------------------------

    */
/**
     *

     * @return un Arraylist de personas con los datos obtenidos del archivo de texto indicado
     * @throws FileNotFoundException
     * @throws IOException
     *//*





    private static ArrayList<Vendedor> cargarVendedores() throws IOException {

        ArrayList<Vendedor> vendedores =new ArrayList<Vendedor>();

        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_VENDEDORES);
        String linea="";

        for (int i = 0; i < contenido.size(); i++)
        {
            linea = contenido.get(i);
            Vendedor vendedor = new Vendedor();
            Cuenta cuenta = new Cuenta();
            vendedor.setNombre(linea.split(",")[0]);
            vendedor.setApellido(linea.split(",")[1]);
            vendedor.setCedula(linea.split(",")[2]);
            vendedor.setDireccion(linea.split(",")[3]);
            vendedores.add(vendedor);
        }
        return vendedores;
    }

*/



    public static void guardaRegistroLog(String mensajeLog, int nivel, String accion)
    {

        ArchivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_LOG);
    }


    //------------------------------------SERIALIZACI�N  y XML


    public static Hostal cargarRecursoHostalBinario() {

        Hostal hostal = null;

        try {
            hostal = (Hostal) ArchivoUtil.cargarRecursoSerializado(RUTA_ARCHIVO_MODELO_HOTAL_BINARIO);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return hostal;
    }

    public static void guardarRecursoHostalBinario(Hostal hostal) {

        try {
            ArchivoUtil.salvarRecursoSerializado(RUTA_ARCHIVO_MODELO_HOTAL_BINARIO, hostal);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static Hostal cargarRecursoHostalXML() {

        Hostal hostal = null;

        try {
            hostal = (Hostal) ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_HOSTAL_XML);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return hostal;

    }



    public static void guardarRecursoHostalXML(Hostal hostal) {

        try {
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_HOSTAL_XML, hostal);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
