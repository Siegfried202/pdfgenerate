package com.kabodpixel.pdfgenerate.service;

import org.springframework.stereotype.Service;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;

@Service
public class PdfGenerationService {
    private final HtmlRenderingService htmlRenderingService;

    public PdfGenerationService(HtmlRenderingService htmlRenderingService) {
        this.htmlRenderingService = htmlRenderingService;
    }

    public byte[] generatePdf(String templateName, Object model) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            // Rendre le contenu HTML avec Thymeleaf
            String htmlContent = htmlRenderingService.renderHtml(templateName, model);

            // Générer le PDF avec ITextRenderer
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(htmlContent);
            renderer.layout();
            renderer.createPDF(outputStream);

            return outputStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Error while generating PDF", e);
        }
    }
}
