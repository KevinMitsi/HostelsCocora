package com.example.hostelscocora.Controllers;

import com.example.hostelscocora.Model.Hostal;
import com.example.hostelscocora.Persistencia.Persistencia;

public class ModelFactoryController {
    Hostal hostal;
    //------------------------------  Singleton ------------------------------------------------
    // Clase estatica oculta. Tan solo se instanciara el singleton una vez
    private static class SingletonHolder {
        // El constructor de Singleton puede ser llamado desde aqu� al ser protected
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    // M�todo para obtener la instancia de nuestra clase
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController() {


        //1. inicializar datos y luego guardarlo en archivos
//		iniciarSalvarDatosPrueba();

        //2. Cargar los datos de los archivos
//		cargarDatosDesdeArchivos();


        //3. Guardar y Cargar el recurso serializable binario
        guardarResourceBinario();
//		cargarResourceBinario();

        //4. Guardar y Cargar el recurso serializable XML
//		guardarResourceXML();
        cargarResourceXML();


        //Siempre se debe verificar si la raiz del recurso es null
        if(hostal == null)
        {
            System.out.println("es null");
            inicializarDatos();
            guardarResourceXML();
            guardarResourceBinario();
        }

        //Registrar la accion de incio de sesi�n
        Persistencia.guardaRegistroLog("Inicio de sesion del usuario:pedro", 1, "inicioSesion");


    }


    public void guardarResourceBinario() {

        Persistencia.guardarRecursoHostalBinario(hostal);
    }


    public void cargarResourceXML() {

        hostal = Persistencia.cargarRecursoHostalXML();
    }


    public void guardarResourceXML() {

        Persistencia.guardarRecursoHostalXML(hostal);
    }



    private void inicializarDatos() {

        hostal = new Hostal();



        System.out.println("Snowalowe inicializado "+ hostal );

    }



}
