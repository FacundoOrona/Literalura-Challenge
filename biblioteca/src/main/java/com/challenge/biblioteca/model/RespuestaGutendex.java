package com.challenge.biblioteca.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RespuestaGutendex {
    @JsonAlias("count")
    private int total;
    @JsonAlias("results")
    private List<LibroDto> resultados;

    public int getTotal() { return total; }
    public void setTotal(int total) { this.total = total; }

    public List<LibroDto> getResultados() { return resultados; }
    public void setResultados(List<LibroDto> resultados) { this.resultados = resultados; }

    @Override
    public String toString() {
        return "total: " + total +
                ", resultados: " + resultados;
    }
}

