package rl242dev.discordlinker.handler;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import rl242dev.discordlinker.DiscordLinker;

public class ChatListener implements Listener{

    @EventHandler
    public void onChat(PlayerChatEvent event){
        StringBuilder builder = new StringBuilder(DiscordLinker.getInstance().getConfig().getString("BASE_POST_URL")+"/message/");

        builder.append((event.getMessage()));
        builder.append("/");
        builder.append(event.getPlayer().toString());

        try {
            URL url = new URL(builder.toString());
            URLConnection con = url.openConnection();
            HttpURLConnection http = (HttpURLConnection)con;
            http.setRequestMethod("POST"); 
        }catch(IOException e){
            System.out.println((e.getMessage()));
        }
        
        return;
    }
    
}
