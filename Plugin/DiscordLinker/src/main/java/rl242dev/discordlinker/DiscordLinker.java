package rl242dev.discordlinker;

import org.bukkit.plugin.java.JavaPlugin;

import rl242dev.discordlinker.handler.ChatListener;

public final class DiscordLinker extends JavaPlugin {

    public static DiscordLinker instance;

    @Override
    public void onEnable() {
        saveConfig();

        instance = this;

        getServer().getPluginManager().registerEvents(new ChatListener(), this);
    }

    @Override
    public void onDisable() {
        System.out.println("ShutDown");
    }

    public static DiscordLinker getInstance(){
        return instance;
    }
}
