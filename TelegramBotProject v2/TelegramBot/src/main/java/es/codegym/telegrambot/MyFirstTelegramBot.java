package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static es.codegym.telegrambot.TelegramBotContent.*;


public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "NubioBot_bot";
    public static final String TOKEN = "6422471334:AAEGlgq8rQtGI4PqOf7QsiVHSHH7OEV9EPw";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        // TODO: escribiremos la funcionalidad principal del bot aquí
        if (getMessageText().equalsIgnoreCase("/start")) {
            setUserGlory(0);
            sendPhotoMessageAsync("step_1_pic");
            sendTextMessageAsync(STEP_1_TEXT, Map.of("Hackear la nevera", "step_1_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_1_btn")) {
            setUserGlory(20);
            sendPhotoMessageAsync("step_2_pic");
            sendTextMessageAsync(STEP_2_TEXT,
                    Map.of("Tomar Salchicha! +  20 de fama", "step_2_btn",
                            "Tomar un pescado! + 20 de fama", "step_2_btn",
                            "Tomar una lata de pepinillos + 20 puntos", "step_2_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_2_btn")) {
            addUserGlory(20);
            sendPhotoMessageAsync("step_3_pic");
            sendTextMessageAsync(STEP_3_TEXT,
                    Map.of("Hackear al robot aspiradora!" , "step_3_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_3_btn")) {
            addUserGlory(30);
            sendPhotoMessageAsync("step_4_pic");
            sendTextMessageAsync(STEP_4_TEXT,
                    Map.of("Enviar al robot aspiradora por comida! +  30 de fama", "step_4_btn",
                            "Dar un paseo en el robot aspiradora! +  30 de fama", "step_4_btn",
                            "Huir del robot aspiradora! +  30 de fama", "step_4_btn",
                            "Irse a dormir ! =  0 de fama", "step_endgame_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_4_btn")) {
            addUserGlory(30);
            sendPhotoMessageAsync("step_5_pic");
            sendTextMessageAsync(STEP_5_TEXT,
                    Map.of("Encender la GoPro y usarla! +  40 de fama", "step_5_btn",
                            "No usar la GoPro e irse a dormir ! =  0 de fama", "step_endgame_btn"
                            ));
        }
        if (getCallbackQueryButtonKey().equals("step_5_btn")) {
            addUserGlory(40);
            sendPhotoMessageAsync("step_6_pic");
            sendTextMessageAsync(STEP_6_TEXT,
                    Map.of("Crear contenido con los Gatos vecinos y grabalo +  40 de fama" , "step_6_btn",
                            "No grabar e irse a dormir ! =  0 de fama", "step_endgame_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_6_btn")) {
            addUserGlory(40);
            sendPhotoMessageAsync("step_7_pic");
            sendTextMessageAsync(STEP_7_TEXT,
                    Map.of("Hackear la computadora y subir el video + 50 de fama" , "step_7_btn",
                            "No hackear la computadora ! =  0 de fama", "step_endgame_btn"));
        }if (getCallbackQueryButtonKey().equals("step_7_btn")) {
            addUserGlory(50);
            sendPhotoMessageAsync("step_8_pic");
            sendTextMessageAsync(STEP_8_TEXT,
                    Map.of("Salir al patio con los Gatos vecinos!" , "step_8_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_8_btn")) {
            addUserGlory(20);
            sendTextMessageAsync(FINAL_TEXT);
            sendPhotoMessageAsync("final_pic");
        }
        if (getCallbackQueryButtonKey().equals("step_endgame_btn")){
            setUserGlory(0);
            sendTextMessageAsync(LOOSER_TEXT);
        }



    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}
