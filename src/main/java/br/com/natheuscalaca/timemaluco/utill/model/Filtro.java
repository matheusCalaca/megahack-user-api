package br.com.natheuscalaca.timemaluco.utill.model;

import javax.enterprise.inject.Default;
import java.util.List;
import java.util.Map;

public class Filtro {

    private List<String> sort;
    /**
     *  true para ASC
     *  false para DESC
     */
    private boolean sort_type = true ;
    private Map<String, Object> filter;

    public boolean isSort_type() {
        return sort_type;
    }

    public void setSort_type(boolean sort_type) {
        this.sort_type = sort_type;
    }

    public Map<String, Object> getFilter() {
        return filter;
    }

    public void setFilter(Map<String, Object> filter) {
        this.filter = filter;
    }

    public List<String> getSort() {
        return sort;
    }

    public void setSort(List<String> sort) {
        this.sort = sort;
    }
}
