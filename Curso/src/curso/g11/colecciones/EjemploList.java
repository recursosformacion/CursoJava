package curso.g11.colecciones;

import java.util.*;

public class EjemploList {
    public static void main(String[] args) {
        List<String> list = Arrays.asList(args);
//        Collections.shuffle(list);
        System.out.println(list);
    }
}