package pl.funnyskaddon.skript.effects.guilds;

import org.bukkit.Location;
import org.bukkit.craftbukkit.libs.jline.internal.Nullable;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import net.dzikoysk.funnyguilds.basic.guild.Guild;
import net.dzikoysk.funnyguilds.basic.user.User;

public class PlayerGuildSetHomeLocation extends Effect{
    private Expression<Player> pl;
    private Expression<Location> loc;
    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] expr, int matchedPattern, Kleenean paramKleenean, ParseResult paramParseResult) {
        pl = (Expression<Player>) expr[0];
        loc = (Expression<Location>) expr[1];
        return true;
    }
    @Override
    public String toString(@Nullable Event e, boolean b) {
        return null;
    }
    @Override
    protected void execute(Event e) {
    	try {
	    	Guild g = User.get(pl.getSingle(e)).getGuild();
	        try {
	        	g.setHome(loc.getSingle(e));
	        } catch(Exception ex) {
	        	return;
	        }
    	} catch(Exception ex) { return;}
    }
}