package com.crudspring.api.DTOs;

import java.util.List;

public class PublicationResponse {
    private List<PublicationDTO> contenido;
    private int numPage;
    private int sizePage;
    private long totalElemnt;
    private int totalpage;
    private boolean latest;

    public List<PublicationDTO> getContenido() {
        return contenido;
    }

    public void setContenido(List<PublicationDTO> contenido) {
        this.contenido = contenido;
    }

    public int getNumPage() {
        return numPage;
    }

    public void setNumPage(int numPage) {
        this.numPage = numPage;
    }

    public int getSizePage() {
        return sizePage;
    }

    public void setSizePage(int sizePage) {
        this.sizePage = sizePage;
    }

    public long getTotalElemnt() {
        return totalElemnt;
    }

    public void setTotalElemnt(long totalElemnt) {
        this.totalElemnt = totalElemnt;
    }

    public int getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }

    public boolean isLatest() {
        return latest;
    }

    public void setLatest(boolean latest) {
        this.latest = latest;
    }

    public PublicationResponse() {
        super();
    }

}
