package org.example;

import Services.PexelsApi;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

public class SportManagerBot implements LongPollingSingleThreadUpdateConsumer {
    private final TelegramClient telegramClient;

    public SportManagerBot(String botToken) {
        telegramClient = new OkHttpTelegramClient(botToken);
    }

    @Override
    public void consume(Update update) {
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            // Set variables
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();

            String command = update.getMessage().getText();

            switch (command) {
                case "/photo f1":
                    sendPhoto(command, chat_id);
                    break;
            }
        }
    }

    private void sendPhoto(String command, long chat_id){
        PexelsApi pexelsApi = new PexelsApi();

        String query = command.replace("/photo", "").trim();
        String url = pexelsApi.getPhotoUrl(query);

        if(url == null){
            try {
                telegramClient.execute(buildMessage("Nessuna immagine trovata 😒", chat_id));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
            return;
        }

        try {
            telegramClient.execute(buildPhotoMessage(url, query, chat_id));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private SendMessage buildMessage(String msg, long chat_id){
        return SendMessage
                .builder()
                .chatId(chat_id)
                .text(msg)
                .build();
    }

    private SendPhoto buildPhotoMessage(String url, String query, long chat_id){
        return SendPhoto
                .builder()
                .chatId(chat_id)
                .photo(new InputFile(url))
                .caption("Ecco un'immagine su: " + query)
                .build();
    }
}


