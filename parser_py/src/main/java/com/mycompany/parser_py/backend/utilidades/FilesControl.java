package com.mycompany.parser_py.backend.utilidades;

import com.kitfox.svg.Path;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Clase que contiene gestiona los archivos
 *
 * @author giovanic
 */
public class FilesControl {

    /**
     * Metodo para leer archivos de texto
     *
     * @return lista con todo el contenido del archivo de texto
     */
    public List<String> reader() {
        List<String> str = new ArrayList<>();
        try {
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.txt", "txt");
            File myObj = seleccionarArchivo(filtro);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                str.add(myReader.nextLine());
            }
        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println("error -> No se pudo leer el archivo");
        }
        return str;
    }

    /**
     * Metodo para obtener un file
     *
     * @param filtro la extension predeterminada que se muestra en el
     * filechooser
     * @return File
     * @throws FileNotFoundException
     */
    public File seleccionarArchivo(FileNameExtensionFilter filtro) throws FileNotFoundException {
        JFileChooser fileChooser = new JFileChooser("src");
        fileChooser.setFileFilter(filtro);
        int respuesta = fileChooser.showOpenDialog(null);
        switch (respuesta) {
            case JFileChooser.APPROVE_OPTION -> {
                return fileChooser.getSelectedFile();
            }
            case JFileChooser.CANCEL_OPTION, JFileChooser.ERROR_OPTION -> {
                return null;
            }
        }
        return null;
    }

    public String getContenido() {
        String cont = "";
        try {
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.txt", "txt");
            File myObj = seleccionarArchivo(filtro);
            cont = getArchivo(myObj.getAbsolutePath());
        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println("error -> No se pudo leer el archivo");
        }
        return cont;
    }

    //-------------------------Se obtiene el contenido del Archivo----------------//
    private String getArchivo(String ruta) {
        FileReader fr = null;
        BufferedReader br = null;
        //Cadena de texto donde se guardara el contenido del archivo
        String contenido = "";
        try {
            //ruta puede ser de tipo String o tipo File
            fr = new FileReader(ruta);
            br = new BufferedReader(fr);

            String linea;
            //Obtenemos el contenido del archivo linea por linea
            while ((linea = br.readLine()) != null) {
                contenido += linea + "\n";
            }

        } catch (IOException e) {
        } //finally se utiliza para que si todo ocurre correctamente o si ocurre 
        //algun error se cierre el archivo que anteriormente abrimos
        finally {
            try {
                br.close();
            } catch (IOException ex) {
            }
        }
        return contenido;
    }

    private File createFile(String fileName) {
        try {
            File myObj = new File("example/" + fileName + ".dot");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
            return myObj;
        } catch (IOException e) {
        }
        return null;
    }

    public void writeFile(String contenido, String fileName) {
        try {
            File file = createFile(fileName);
            try (FileWriter myWriter = new FileWriter(file)) {
                myWriter.write(contenido);
            }
            System.out.println("Successfully wrote to the file.");
        } catch (IOException | NullPointerException e) {
            System.out.println("An error occurred.");
        }
    }

    /**
     * Metodo para eliminar un archivo.
     *
     * @param file_name ruta del archivo y nombre
     */
    public void eliminarArchivo(String file_name) {
        File file = new File(file_name);
        file.delete();
    }
}
