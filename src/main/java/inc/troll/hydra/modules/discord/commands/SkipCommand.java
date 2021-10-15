package inc.troll.hydra.modules.discord.commands;

import inc.troll.hydra.modules.audio.HydraManager;
import inc.troll.hydra.modules.audio.TrackScheduler;
import net.dv8tion.jda.api.entities.GuildVoiceState;

public class SkipCommand implements ICommand {

    @Override
    public void handle(CommandContext ctx) {
        if (ctx.areBotAndUserInSameVoiceChannel()) {
            TrackScheduler scheduler = HydraManager.getInstance()
                .getMusicManager(ctx.getGuild())
                .getScheduler();

            if(scheduler.isPlaying()) {
                scheduler.nextTrack();
            }
        }
    }

    @Override
    public String getName() {
        return "skip";
    }

    @Override
    public String getHelp() {
        return new StringBuilder()
            .append("skip current song\n")
            .append("usage: `.skip`")
            .toString();
    }
}
