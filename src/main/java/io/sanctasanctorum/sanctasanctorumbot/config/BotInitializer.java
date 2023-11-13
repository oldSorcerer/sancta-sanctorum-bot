package io.sanctasanctorum.sanctasanctorumbot.config;

import io.sanctasanctorum.sanctasanctorumbot.service.TelegramBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BotInitializer {

    @Autowired
    TelegramBot bot;

}
