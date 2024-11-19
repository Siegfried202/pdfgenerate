package com.kabodpixel.pdfgenerate.entity;

import java.time.LocalDate;

public class PdfData {
    private String nom;
    private double amount;
    private LocalDate date;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
