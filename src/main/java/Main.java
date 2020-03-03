import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter {
    public static void main(String[] args) throws LoginException {
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        String token = "Njg0MzIwNzA5MzQxNzQxMDU2.Xl4ZZQ.QEs_fYnROSSOX_wSu4K3usfr7MQ";
        builder.setToken(token);
        builder.addEventListeners(new Main());
        builder.build();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        System.out.println("We received a message from " +
                event.getAuthor().getName() + ": " +
                event.getMessage().getContentDisplay());

        if(event.getMessage().getContentRaw().equals("!ping")){
            event.getChannel().sendMessage("Pong!").queue();
        }
    }
}
