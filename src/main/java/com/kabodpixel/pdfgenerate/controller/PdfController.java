package com.kabodpixel.pdfgenerate.controller;

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
        // Convertir l'objet PdfData en modèle pour Thymeleaf
        Map<String, Object> model = Map.of(
                "name", pdfData.getNom(),
                "amount", pdfData.getAmount(),
                "date", pdfData.getDate()
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
