package com.challenge.biblioteca.model;

import java.util.List;

public class RespuestaGutendex {
    private int total;
    private List<LibroDto> resultados;

    public int getTotal() { return total; }
    public void setTotal(int total) { this.total = total; }

    public List<LibroDto> getResultados() { return resultados; }
    public void setResultados(List<LibroDto> resultados) { this.resultados = resultados; }
}

