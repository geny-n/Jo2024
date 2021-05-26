package com.example.mysncfenquete;

import java.util.HashMap;

public class SNCF {
    private static HashMap<String, Enquete> lesEnquetes = new HashMap<>();
    public static void initialiser () {
        if ( ! lesEnquetes.containsKey("RER A")) lesEnquetes.put("RER A", new Enquete());
        if ( ! lesEnquetes.containsKey("RER B")) lesEnquetes.put("RER B", new Enquete());
        if ( ! lesEnquetes.containsKey("RER C")) lesEnquetes.put("RER C", new Enquete());
        if ( ! lesEnquetes.containsKey("RER D")) lesEnquetes.put("RER D", new Enquete());
        if ( ! lesEnquetes.containsKey("RER E")) lesEnquetes.put("RER E", new Enquete());
    }
    public static Enquete getEnquete (String rer) {
        return lesEnquetes.get(rer);
    }
}
