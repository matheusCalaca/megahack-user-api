package br.com.natheuscalaca.timemaluco.utill.model;

import java.util.List;
import java.util.Map;

public class Filtro {

    private List<String> shorted;
    private Map<String, Object> filter;

    public List<String> getShorted() {
        return shorted;
    }

    public void setShorted(List<String> shorted) {
        this.shorted = shorted;
    }

    public Map<String, Object> getFilter() {
        return filter;
    }

    public void setFilter(Map<String, Object> filter) {
        this.filter = filter;
    }
}
