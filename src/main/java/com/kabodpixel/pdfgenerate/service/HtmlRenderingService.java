package com.kabodpixel.pdfgenerate.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class HtmlRenderingService {
 private final TemplateEngine templateEngine;
  public HtmlRenderingService(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public String renderHtml(String templateName, Object model) {
        Context context = new Context();
        context.setVariables((Map<String, Object>) model);
        return templateEngine.process(templateName, context);
    }

}
