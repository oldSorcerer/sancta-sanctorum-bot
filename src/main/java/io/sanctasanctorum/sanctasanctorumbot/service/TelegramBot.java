package io.sanctasanctorum.sanctasanctorumbot.service;

import io.sanctasanctorum.sanctasanctorumbot.config.BotConfig;
import io.sanctasanctorum.sanctasanctorumbot.model.UserRepository;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(makeFinal = true)
public class TelegramBot extends TelegramLongPollingBot {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BotConfig botConfig;

    public TelegramBot(UserRepository userRepository, BotConfig botConfig) {
        this.userRepository = userRepository;
        this.botConfig = botConfig;
        List<BotCommand> botCommands = new ArrayList<>();

        botCommands.add(new BotCommand("/start", "get Welcome massage"));

        try{
            this.execute(new SetMyCommands(botCommands, new BotCommandScopeDefault(), null));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getBotToken();
    }

    @Override
    public void onUpdateReceived(Update update) {


    }
}
