package com.kabodpixel.pdfgenerate.entity;

public class PdfData {
    private String nomDefunt;
    private String dateFuneraille;
    private String photoDefunt;
    private String description;
    private String paroisse;
    
    private String dateDesces;
    private String dateNaissance;

    
    public String getDateDesces() {
        return dateDesces;
    }
    public void setDateDesces(String dateDesces) {
        this.dateDesces = dateDesces;
    }
    public String getDateNaissance() {
        return dateNaissance;
    }
    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    public String getNomDefunt() {
        return nomDefunt;
    }
    public void setNomDefunt(String nomDefunt) {
        this.nomDefunt = nomDefunt;
    }
    public String getDateFuneraille() {
        return dateFuneraille;
    }
    public void setDateFuneraille(String dateFuneraille) {
        this.dateFuneraille = dateFuneraille;
    }
    public String getPhotoDefunt() {
        return photoDefunt;
    }
    public void setPhotoDefunt(String photoDefunt) {
        this.photoDefunt = photoDefunt;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getParoisse() {
        return paroisse;
    }
    public void setParoisse(String paroisse) {
        this.paroisse = paroisse;
    }
    @Override
    public String toString() {
        return "PdfData [getDateDesces()=" + getDateDesces() + ", getDateNaissance()=" + getDateNaissance()
                + ", getNomDefunt()=" + getNomDefunt() + ", getDateFuneraille()=" + getDateFuneraille()
                + ", getPhotoDefunt()=" + getPhotoDefunt() + ", getDescription()=" + getDescription()
                + ", getParoisse()=" + getParoisse() + "]";
    }
  
  

  
}
