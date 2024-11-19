package com.kabodpixel.pdfgenerate.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kabodpixel.pdfgenerate.entity.PdfData;
import com.kabodpixel.pdfgenerate.service.PdfGenerationService;
@RestController
@RequestMapping("/api/pdf")
public class PdfController {
    private final PdfGenerationService pdfGenerationService;

    public PdfController(PdfGenerationService pdfGenerationService) {
        this.pdfGenerationService = pdfGenerationService;
    }

    @PostMapping(value = "/generate", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> generatePdf(@RequestBody PdfData pdfData) {
        System.out.println(pdfData);
           // Définir le format de la date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // Convertir la chaîne en LocalDateTime
        String dateNaissanceString= pdfData.getDateNaissance();
        String dateDescesString= pdfData.getDateDesces();
        LocalDateTime dateTimeNaissace = LocalDateTime.parse(dateNaissanceString, formatter);
        LocalDateTime dateTimeDescess = LocalDateTime.parse(dateDescesString, formatter);


       
        // Convertir l'objet PdfData en modèle pour Thymeleaf
        Map<String, Object> model = Map.of(
                "name", pdfData.getNomDefunt(),
                "funeraille", pdfData.getDateFuneraille(),
                "photo", "https://www.parentst-hilaire.com/images/photos_defunts/2024/photo_site_Rosaire_Odesse.jpg"/* pdfData.getPhotoDefunt() */,
                "description", pdfData.getDescription(),
                "paroisse", pdfData.getParoisse(),
                "datedesces", dateTimeDescess.getYear(),
                "datenaissance", dateTimeNaissace.getYear(),
                "audela","https://www.parentst-hilaire.com/images/BandeauOdela.jpg"

        );

        // Spécifiez le nom du template Thymeleaf
        String templateName = "template";

        // Générer le PDF
        byte[] pdfBytes = pdfGenerationService.generatePdf(templateName, model);

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=document.pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfBytes);
    }
}
