package com.mycompany.proyectofinal3;

import java.util.ArrayList;
import java.util.List;

public class NodoArbolAVL {
    private final Object data;
    private final List<NodoArbolAVL> hijos;

    public NodoArbolAVL(Object data) {
        this.data = data;
        this.hijos = new ArrayList<>();
    }

    public void addHijo(NodoArbolAVL hijo) {
        hijos.add(hijo);
    }

    public Object getData() { return data; }
    public List<NodoArbolAVL> getHijos() { return hijos; }

    public void mostrar(String prefijo) {
        System.out.println(prefijo + data.toString());
        for (NodoArbolAVL hijo : hijos) {
            hijo.mostrar(prefijo + "   ");
        }
    }
}
