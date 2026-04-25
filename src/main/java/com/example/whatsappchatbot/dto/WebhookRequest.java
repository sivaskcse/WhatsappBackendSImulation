package com.example.whatsappchatbot.dto;

import jakarta.validation.constraints.NotBlank;

public record WebhookRequest(
        @NotBlank(message = "sender is required")
        String sender,
        @NotBlank(message = "message is required")
        String message
) {
}
