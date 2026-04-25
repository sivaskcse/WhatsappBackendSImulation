package com.example.whatsappchatbot.controller;

import com.example.whatsappchatbot.dto.WebhookRequest;
import com.example.whatsappchatbot.dto.WebhookResponse;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping("/webhook")
public class WebhookController {

    private static final Logger logger = LoggerFactory.getLogger(WebhookController.class);

    private static final Map<String, String> REPLIES = Map.of(
            "hi", "Hello",
            "bye", "Goodbye"
    );

    @PostMapping
    public ResponseEntity<WebhookResponse> handleWebhook(@Valid @RequestBody WebhookRequest request) {
        logger.info("Incoming WhatsApp message from {}: {}", request.sender(), request.message());

        String normalizedMessage = request.message().trim().toLowerCase(Locale.ROOT);
        String reply = REPLIES.getOrDefault(normalizedMessage, "I can respond to: Hi, Bye");

        return ResponseEntity.ok(new WebhookResponse(reply));
    }
}
