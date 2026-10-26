
package utils;

import clases.Usuario;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import tools.jackson.core.util.DefaultIndenter;
import tools.jackson.core.util.DefaultPrettyPrinter;
import tools.jackson.databind.MappingIterator;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.ObjectWriter;
import tools.jackson.dataformat.csv.CsvMapper;
import tools.jackson.dataformat.csv.CsvSchema;
import tools.jackson.dataformat.xml.XmlMapper;
import tools.jackson.dataformat.yaml.YAMLFactory;


public class JacksonMapper {

    // **************************************
    // XML
    // **************************************
    public static String xmlMapperWriter(Object obj)  {

        XmlMapper om = new XmlMapper();
        ObjectWriter writer = om.writerWithDefaultPrettyPrinter();
        String xml = writer.writeValueAsString(obj);

        // xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "\n" + xml;
        // System.out.println(xml);
        
        return xml;
    }

    public static <T> T xmlObjectMapperReader(String xml, Class<T> clazz) {
        XmlMapper om = new XmlMapper();
        T obj = om.readValue(xml, clazz);
        return obj;
    }

    // **************************************
    // JSON
    // **************************************
    public static String jsonMapperWriter(Object obj) {
        ObjectMapper om = new ObjectMapper();

        DefaultPrettyPrinter pp = new DefaultPrettyPrinter();
        DefaultIndenter indenter = new DefaultIndenter("  ", DefaultIndenter.SYS_LF); // 2 espacios + newline
        pp.indentObjectsWith(indenter);
        pp.indentArraysWith(indenter);

        ObjectWriter writer = om.writer().with(pp);
        
        String json = writer.writeValueAsString(obj);

//        om.enable(SerializationFeature.INDENT_OUTPUT);
        //System.out.println(json);
        return json;
    }

    public static <T> T jsonObjectMapperReader(String json, Class<T> clazz) {
        ObjectMapper om = new ObjectMapper();
        T obj = om.readValue(json, clazz);
        return obj;
    }

    public static <T> ArrayList<T> jsonArrayMapperReader(String json, Class<T> clazz)  {
        ObjectMapper om = new ObjectMapper();
        ArrayList<T> list = om.readValue(json, om.getTypeFactory().constructCollectionType(ArrayList.class, clazz));
        return list;
    }

    // **************************************
    // YAML
    // **************************************
    public static String yamlMapperWriter(Object obj)  {
        ObjectMapper om = new ObjectMapper(new YAMLFactory());
        String yaml = om.writeValueAsString(obj);
        //System.out.println(yaml);
        return yaml;
    }

    public static <T> T yamlObjectMapperReader(String yaml, Class<T> clazz)  {
        ObjectMapper om = new ObjectMapper(new YAMLFactory());
        T obj = om.readValue(yaml, clazz);
        return obj;
    }

    public static <T> ArrayList<T> yamlArrayMapperReader(String yaml, Class<T> clazz)  {
        ObjectMapper om = new ObjectMapper(new YAMLFactory());
        ArrayList<T> list = om.readValue(yaml, om.getTypeFactory().constructCollectionType(ArrayList.class, clazz));
        return list;
    }

    // **************************************
    // CSV
    // **************************************
    
    public static String csvMapperWriter(ArrayList<?> lista, Class<?> clase) {

        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(clase)
                .withUseHeader(true)
                .withLineSeparator("\n")
                .withColumnSeparator(',')
                .withQuoteChar('\"') // Si este caracter QuoteChar existe en el contenido entonces se duplica
                // .withoutQuoteChar()
                ;

        String csv;
        csv = mapper.writer(schema)
                //.withAttribute("forceQuotes", false) // Personalización para forzar comillas
                .writeValueAsString(lista);
        //System.out.println(csv);
        return csv;


    }

    public static List<?> csvMapperReader(String csv, Class<?> clase) {

        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(clase)
                .withUseHeader(true)
                .withLineSeparator("\n")
                .withColumnSeparator(',')
                .withQuoteChar('\"') // Si este caracter QuoteChar existe en el contenido entonces se duplica
                //.withoutQuoteChar()
                ;

        // Leer el archivo CSV y mapearlo a una lista de objetos Persona
        File archivoCsv = new File(csv);

        MappingIterator<Usuario> it = mapper
                .readerFor(Usuario.class)
                .with(schema)
                .readValues(archivoCsv);
        List<?> lista = it.readAll();

        // Mostrar los objetos mapeados
        //System.out.println(lista);
        return lista;

    }
     
    public static void writeToFile(String path, String content, boolean... append) {
        boolean appendMode = append.length > 0 ? append[0] : false;

        // try-with-resources asegura que el BufferedWriter se cierre automáticamente
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(path, appendMode), StandardCharsets.UTF_8))) {
            writer.write(content);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public static void writeToFileDirect(String path, String content, boolean... append) {
        boolean appendMode = append.length > 0 ? append[0] : false;
        try {
            if (appendMode) {
                Files.writeString(
                        Paths.get(path),
                        content,
                        StandardCharsets.UTF_8,
                        StandardOpenOption.CREATE,
                        StandardOpenOption.APPEND);
            } else {
                Files.writeString(
                        Paths.get(path),
                        content,
                        StandardCharsets.UTF_8,
                        StandardOpenOption.CREATE,
                        StandardOpenOption.TRUNCATE_EXISTING);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static String readFromFileDirect(String path) {
        String content = "";
        try {
            content = Files.readString(Paths.get(path), StandardCharsets.UTF_8);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return content;
    }
    
}
