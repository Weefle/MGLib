package net.amigocraft.mglib.api;

import java.util.HashMap;

import net.amigocraft.mglib.api.Stage;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 * Stores variables for minigames and defaults for rounds for convenience purposes.
 * @since 0.1.0
 */
public class ConfigManager {

	private String plugin;

	private Location exitLocation;
	private int minPlayers = 0;
	private int maxPlayers = 32;
	private String signId;
	private int roundPrepareTime = 90;
	private int roundPlayTime = 300;
	private boolean joinRiP = false;
	private boolean joinRwP = false;
	private boolean pmsAllowed = true;
	private boolean kitsAllowed = true;
	private boolean spectateJoin = false;
	private HashMap<String, ChatColor> lobbyColors = new HashMap<String, ChatColor>();
	private HashMap<String, Boolean> actions = new HashMap<String, Boolean>();
	private Class<? extends MGPlayer> playerClass = MGPlayer.class;
	private GameMode gameMode = GameMode.SURVIVAL;
	private boolean pvp = true;
	private boolean damage = true;
	private boolean rollback = true;
	private boolean spectatorsOnSigns = true;
	private boolean spectatorFlight = true;
	private boolean teamDamage = true;
	private String locale = "enUS";
	private boolean randomSpawns = true;
	private boolean overrideDeathEvent = false;
	private boolean hunger = false;
	private boolean perRoundChat = true;
	private boolean teamChat = false;
	private boolean mobSpawning = true;
	private boolean targeting = false;
	private boolean spectatorChat = true;
	private boolean vanillaSpectating = true;

	/**
	 * Creates a config manager for the given plugin.
	 * @param plugin the plugin to associate this config manager with.
	 * @since 0.1.0
	 */
	public ConfigManager(String plugin){
		this.plugin = plugin;
		this.exitLocation = Bukkit.getWorlds().get(0).getSpawnLocation();
		this.signId = "[" + plugin + "]";

		lobbyColors.put("arena", ChatColor.DARK_RED);
		lobbyColors.put("waiting", ChatColor.DARK_GRAY);
		lobbyColors.put("preparing", ChatColor.RED);
		lobbyColors.put("playing", ChatColor.DARK_PURPLE);
		lobbyColors.put("resetting", ChatColor.DARK_GRAY);
		lobbyColors.put("time", ChatColor.GREEN);
		lobbyColors.put("time-warning", ChatColor.RED);
		lobbyColors.put("time-infinite", ChatColor.GREEN);
		lobbyColors.put("player-count", ChatColor.GREEN);
		lobbyColors.put("player-count-full", ChatColor.RED);

		actions.put("teleport", true);
		actions.put("block-place", false);
		actions.put("block-break", false);
		actions.put("block-burn", false);
		actions.put("block-fade", false);
		actions.put("block-grow", false);
		actions.put("block-ignite", false);
		actions.put("block-flow", false);
		actions.put("block-physics", true);
		actions.put("block-piston", true);
		actions.put("block-spread", false);
		actions.put("entity-explode", false);
		actions.put("hanging-break", false);
		actions.put("item-frame-damage", false);
	}

	/**
	 * Retrieves the {@link Minigame} associated with this config manager.
	 * @return the {@link Minigame} associated with this config manager.
	 * @since 0.1.0
	 */
	public Minigame getMinigame(){
		return Minigame.getMinigameInstance(plugin);
	}

	/**
	 * Retrieves the name of the plugin associated with this config manager.
	 * @return the name of the plugin associated with this config manager.
	 * @since 0.1.0
	 */
	public String getPlugin(){
		return plugin;
	}

	/**
	 * Retrives the default exit location for players upon round end (default: the spawn point of the main world).
	 * @return the default exit location for players upon round end.
	 * @since 0.1.0
	 */
	public Location getDefaultExitLocation(){
		return exitLocation;
	}

	/**
	 * Sets this default exit location for players upon a {@link Round round} ending (default: the spawn point of the main world).
	 * @param exitLocation this default exit location for players upon a {@link Round round} ending.
	 * @since 0.1.0
	 */
	public void setDefaultExitLocation(Location exitLocation){
		this.exitLocation = exitLocation;
	}

	/**
	 * Retrieves the default minimum number of players required to automatically start a {@link Round round}. (default: 0 (no minimum))
	 * @return the default minimum number of players required to automatically start a {@link Round round}.
	 * @since 0.2.0
	 */
	public int getMinPlayers(){
		return minPlayers;
	}

	/**
	 * Sets the default minimum number of players required to automatically start a {@link Round round}.
	 * Set to 0 (default) for no autostart.
	 * @param minPlayers the default minimum number of players required to automatically start a {@link Round round}.
	 * @since 0.2.0
	 */
	public void setMinPlayers(int minPlayers){
		this.minPlayers = minPlayers;
	}

	/**
	 * Retrieves the default maximum number of players allowed in a {@link Round round} at one time (default: 32).
	 * @return the default maximum number of players allowed in a {@link Round round} at one time.
	 * @since 0.1.0
	 */
	public int getMaxPlayers(){
		return maxPlayers;
	}

	/**
	 * Sets the default maximum number of players allowed in a {@link Round round} at one time (default: 32).
	 * Set to 0 for no limit.
	 * @param maxPlayers the default maximum number of players allowed in a {@link Round round} at one time.
	 * @since 0.1.0
	 */
	public void setMaxPlayers(int maxPlayers){
		this.maxPlayers = maxPlayers;
	}

	/**
	 * Retrieves the associated plugin {@link LobbySign lobby sign} identifier, used to recognize lobby signs.
	 * (default: your plugin's name in square brackets)
	 * @return the associated plugin {@link LobbySign lobby sign} identifier, used to recognize lobby signs.
	 * @since 0.1.0
	 */
	public String getSignId(){
		return signId;
	}

	/**
	 * Sets the associated plugin {@link LobbySign lobby sign} identifier, used to recognize lobby signs.
	 * (default: your plugin's name in square brackets)
	 * @param signId the associated plugin {@link LobbySign lobby sign} identifier, used to recognize lobby signs.
	 * @since 0.1.0
	 */
	public void setSignId(String signId){
		this.signId = signId;
	}

	/**
	 * Sets the default time allotted to a round's {@link Stage#PREPARING preparation} period (default: 90).
	 * @return the default time allotted to a round's {@link Stage#PREPARING preparation} period.
	 * @since 0.1.0
	 */
	public int getDefaultPreparationTime(){
		return roundPrepareTime;
	}

	/**
	 * Sets the default time allotted to a round's {@link Stage#PREPARING preparation} period (default: 90).
	 * Set to a value less than or equal to zero to skip the preparation period.
	 * @param preparationTime the default time allotted to a round's {@link Stage#PREPARING preparation} period.
	 * @since 0.1.0
	 */
	public void setDefaultPreparationTime(int preparationTime){
		this.roundPrepareTime = preparationTime;
	}

	/**
	 * Retrieves the default time allotted to a round's {@link Stage#PLAYING playing} period (default: 300).
	 * @return the default time allotted to a round's {@link Stage#PLAYING playing} period.
	 * @since 0.1.0
	 */
	public int getDefaultPlayingTime(){
		return roundPlayTime;
	}

	/**
	 * Sets the default time allotted to a round's {@link Stage#PLAYING playing} period (default: 300).
	 * Set to a value less than or equal to zero for an indefinite (infinite) time limit.
	 * @param playingTime the default time allotted to a round's {@link Stage#PLAYING playing} period.
	 * @since 0.1.0
	 */
	public void setDefaultPlayingTime(int playingTime){
		this.roundPlayTime = playingTime;
	}

	/**
	 * Retrieves whether players are allowed to join a round which {@link Stage#PLAYING has already started}. (default: false)
	 * @return whether players are allowed to join a round which {@link Stage#PLAYING has already started.}
	 * @since 0.1.0
	 */
	public boolean getAllowJoinRoundInProgress(){
		return joinRiP;
	}

	/**
	 * Sets whether players are allowed to join a round which {@link Stage#PLAYING has already started}. (default: false)
	 * @param allow whether players are allowed to join a round which {@link Stage#PLAYING has already started.}
	 * @since 0.1.0
	 */
	public void setAllowJoinRoundInProgress(boolean allow){
		this.joinRiP = allow;
	}

	/**
	 * Retrieves whether players are allowed to join a round which {@link Stage#PREPARING is in its preparation stage}. (default: false)
	 * @return whether players are allowed to join a round which {@link Stage#PREPARING is in its preparation stage.}
	 * @since 0.1.0
	 */
	public boolean getAllowJoinRoundWhilePreparing(){
		return joinRwP;
	}

	/**
	 * Sets whether players are allowed to join a round which {@link Stage#PREPARING is in its preparation stage}. (default: false)
	 * @param allow whether players are allowed to join a round which {@link Stage#PREPARING is in its preparation stage}.
	 * @since 0.1.0
	 */
	public void setAllowJoinRoundWhilePreparing(boolean allow){
		this.joinRwP = allow;
	}

	/**
	 * Retrieves whether players will be set to spectator mode upon joining around in progress. (default: false)
	 * @return whether players will be set to spectator mode upon joining around in progress.
	 * @since 0.1.0
	 */
	public boolean getSpectateOnJoin(){
		return spectateJoin;
	}

	/**
	 * Sets whether players will be set to spectator mode upon joining around in progress. (default: false) This will have no effect if both
	 * {@link ConfigManager#getAllowJoinRoundWhilePreparing()} and {@link ConfigManager#getAllowJoinRoundInProgress()} return false.
	 * @param allowed whether players will be set to spectator mode upon joining around in progress.
	 * @since 0.1.0
	 */
	public void setSpectateOnJoin(boolean allowed){
		this.spectateJoin = allowed;
	}

	/**
	 * Retrieves the color of the top line (the arena name) of a lobby sign.
	 * @return the color of the top line (the arena name) of a lobby sign.
	 * @since 0.1.0
	 */
	public ChatColor getLobbyArenaColor(){
		return lobbyColors.get("arena");
	}

	/**
	 * Sets the color of the top line (the arena name) of a lobby sign.
	 * @param color the new color of the top line of a lobby sign.
	 * @since 0.1.0
	 */
	public void setLobbyArenaColor(ChatColor color){
		lobbyColors.put("arena", color);
	}

	/**
	 * Retrieves the color of a lobby sign's {@link Stage#WAITING WAITING} status.
	 * @return the color of a lobby sign's {@link Stage#WAITING WAITING} status.
	 * @since 0.1.0
	 */
	public ChatColor getLobbyWaitingColor(){
		return lobbyColors.get("waiting");
	}

	/**
	 * Sets the color of a lobby sign's {@link Stage#WAITING WAITING} status.
	 * @param color the new color of a lobby sign's {@link Stage#WAITING WAITING} status.
	 * @since 0.1.0
	 */
	public void setLobbyWaitingColor(ChatColor color){
		lobbyColors.put("waiting", color);
	}

	/**
	 * Retrieves the color of a lobby sign's {@link Stage#PREPARING PREPARING} status.
	 * @return the color of a lobby sign's {@link Stage#PREPARING PREPARING} status.
	 * @since 0.1.0
	 */
	public ChatColor getLobbyPreparingColor(){
		return lobbyColors.get("preparing");
	}

	/**
	 * Sets the color of a lobby sign's {@link Stage#PREPARING PREPARING} status.
	 * @param color the new color of a lobby sign's {@link Stage#PREPARING PREPARING} status.
	 * @since 0.1.0
	 */
	public void setLobbyPreparingColor(ChatColor color){
		lobbyColors.put("preparing", color);
	}

	/**
	 * Retrieves the color of a lobby sign's {@link Stage#PLAYING PLAYING} status.
	 * @return the color of a lobby sign's {@link Stage#PLAYING PLAYING} status.
	 * @since 0.1.0
	 */
	public ChatColor getLobbyPlayingColor(){
		return lobbyColors.get("playing");
	}

	/**
	 * Sets the color of a lobby sign's {@link Stage#PLAYING PLAYING} status.
	 * @param color the new color of a lobby sign's {@link Stage#PLAYING PLAYING} status.
	 * @since 0.1.0
	 */
	public void setLobbyPlayingColor(ChatColor color){
		lobbyColors.put("playing", color);
	}

	/**
	 * Retrieves the color of a lobby sign's {@link Stage#RESETTING RESETTING} status.
	 * @return the color of a lobby sign's {@link Stage#RESETTING RESETTING} status.
	 * @since 0.1.0
	 */
	public ChatColor getLobbyResettingColor(){
		return lobbyColors.get("resetting");
	}

	/**
	 * Sets the color of a lobby sign's {@link Stage#RESETTING RESETTING} status.
	 * @param color the new color of a lobby sign's {@link Stage#RESETTING RESETTING} status.
	 * @since 0.1.0
	 */
	public void setLobbyResettingColor(ChatColor color){
		lobbyColors.put("resetting", color);
	}

	/**
	 * Retrieves the color of a lobby sign's timer when remaining time is greater than 60 seconds.
	 * @return the color of a lobby sign's timer when remaining time is greater than 60 seconds.
	 * @since 0.1.0
	 */
	public ChatColor getLobbyTimeColor(){
		return lobbyColors.get("time");
	}

	/**
	 * Sets the color of a lobby sign's timer when remaining time is greater than 60 seconds.
	 * @param color the new color of a lobby sign's timer when remaining time is greater than 60 seconds.
	 * @since 0.1.0
	 */
	public void setLobbyTimeColor(ChatColor color){
		lobbyColors.put("time", color);
	}

	/**
	 * Retrieves the color of a lobby sign's timer when remaining time is less than 60 seconds.
	 * @return the color of a lobby sign's timer when remaining time is less than 60 seconds.
	 * @since 0.1.0
	 */
	public ChatColor getLobbyTimeWarningColor(){
		return lobbyColors.get("time-warning");
	}

	/**
	 * Sets the color of a lobby sign's timer when remaining time is less than 60 seconds.
	 * @param color the new color of a lobby sign's timer when remaining time is less than 60 seconds.
	 * @since 0.1.0
	 */
	public void setLobbyTimeWarningColor(ChatColor color){
		lobbyColors.put("time-warning", color);
	}

	/**
	 * Retrieves the color of a lobby sign's timer when remaining time is infinite.
	 * @return the color of a lobby sign's timer when remaining time is infinite.
	 * @since 0.1.0
	 */
	public ChatColor getLobbyTimeInfiniteColor(){
		return lobbyColors.get("time-infinite");
	}

	/**
	 * Sets the color of a lobby sign's timer when remaining time is infinite.
	 * @param color the new color of a lobby sign's timer when remaining time is infinite.
	 * @since 0.1.0
	 */
	public void setLobbyTimeInfiniteColor(ChatColor color){
		lobbyColors.put("time-infinite", color);
	}

	/**
	 * Retrieves the color of a lobby sign's player count when the round is not full.
	 * @return the color of a lobby sign's player count when the round is not full.
	 * @since 0.1.0
	 */
	public ChatColor getLobbyPlayerCountColor(){
		return lobbyColors.get("player-count");
	}

	/**
	 * Sets the color of a lobby sign's player count when the round is not full.
	 * @param color the new color of a lobby sign's player count when the round is not full.
	 * @since 0.1.0
	 */
	public void setLobbyPlayerCountColor(ChatColor color){
		lobbyColors.put("player-count", color);
	}

	/**
	 * Retrieves the color of a lobby sign's player count when the round is full.
	 * @return the color of a lobby sign's player count when the round is full.
	 * @since 0.1.0
	 */
	public ChatColor getLobbyPlayerCountFullColor(){
		return lobbyColors.get("player-count-full");
	}

	/**
	 * Sets the color of a lobby sign's player count when the round is full.
	 * @param color the new color of a lobby sign's player count when the round is full.
	 * @since 0.1.0
	 */
	public void setLobbyPlayerCountFullColor(ChatColor color){
		lobbyColors.put("player-count-full", color);
	}

	/**
	 * Retrieves a copy of the hashmap containing all color attributes for lobby signs associated with this manager's plugin.
	 * @return a copy of the hashmap containing all color attributes for lobby signs associated with this manager's plugin.
	 * @since 0.1.0
	 */
	@SuppressWarnings("unchecked")
	public HashMap<String, ChatColor> getLobbyColorAttributes(){
		return (HashMap<String, ChatColor>)lobbyColors.clone();
	}

	/**
	 * Retrieves a specific color attribute for lobby signs associated with this manager's plugin.
	 * @param key the attribute to fetch the color for.
	 * @return a specific color attribute for lobby signs associated with this manager's plugin,
	 * or null if it does not exist.
	 * @since 0.1.0
	 */
	public ChatColor getLobbyColorAttribute(String key){
		return lobbyColors.get(key);
	}

	/**
	 * Sets a specific color attribute for lobby signs associated with this manager's plugin.
	 * If the provided key is not used in the library, this method will have no effect.
	 * @param key the key of the color attribute (e.g. arena, player-count, time).
	 * @param color the color to associate with aforementioned key.
	 * @since 0.1.0
	 */
	public void setLobbyColor(String key, ChatColor color){
		lobbyColors.put(key, color);
	}

	/**
	 * Retrieves whether teleportation (via ender pearl, command, or another plugin) is permitted for players in a {@link Round round}. (default: true)
	 * @return whether teleportation is permitted for players in a {@link Round round}.
	 * @since 0.1.0
	 */
	public boolean isTeleportationAllowed(){
		return actions.get("teleport");
	}

	/**
	 * Sets whether teleportation (via ender pearl, command, or another plugin) is permitted for players in a {@link Round round}. (default: true)
	 * @param allowed whether teleportation is permitted for players in a {@link Round round}.
	 * @since 0.1.0
	 */
	public void setTeleportationAllowed(boolean allowed){
		actions.put("teleport", allowed);
	}

	/**
	 * Retrieves whether players partaking in a minigame are permitted to send private messages or use the /pm command. (default: true)
	 * This can help limit communication of volatile information between teams, such as in <a href="http://dev.bukkit.org/bukkit-plugins/TTT">TTT</a>.
	 * @return whether players partaking in a minigame are permitted to send private messages or use the /pm command.
	 * @since 0.1.0
	 */
	public boolean arePMsAllowed(){
		return pmsAllowed;
	}

	/**
	 * Sets whether players partaking in a minigame are permitted to send private messages or use the /pm command. (default: true)
	 * @param allowed whether players partaking in a minigame are permitted to send private messages or use the /pm command.
	 * @since 0.1.0
	 */
	public void setPMsAllowed(boolean allowed){
		this.pmsAllowed = allowed;
	}

	/**
	 * Retrieves whether players are permitted to use the /kit command while partaking in a minigame. (default: true)
	 * @return whether players are permitted to use the /kit command while partaking in a minigame.
	 * @since 0.1.0
	 */
	public boolean areKitsAllowed(){
		return kitsAllowed;
	}

	/**
	 * Sets whether players are permitted to use the /kit command while partaking in a minigame. (default: true)
	 * @param allowed whether players are permitted to use the /kit command while partaking in a minigame.
	 * @since 0.1.0
	 */
	public void setKitsAllowed(boolean allowed){
		this.kitsAllowed = allowed;
	}

	/**
	 * Retrieves whether block placing is permitted for players in a {@link Round round}. (default: false)
	 * @return whether block placing is permitted for players in a {@link Round round}.
	 * @since 0.1.0
	 */
	public boolean isBlockPlaceAllowed(){
		return actions.get("block-place");
	}

	/**
	 * Sets whether block placing is permitted for players in a {@link Round round}. (default: false)
	 * @param allowed whether block placing is permitted for players in a {@link Round round}.
	 * @since 0.1.0
	 */
	public void setBlockPlaceAllowed(boolean allowed){
		actions.put("block-place", allowed);
	}

	/**
	 * Retrieves whether block breaking is permitted for players in a {@link Round round}. (default: false)
	 * @return whether block breaking is permitted for players in a {@link Round round}.
	 * @since 0.1.0
	 */
	public boolean isBlockBreakAllowed(){
		return actions.get("block-break");
	}

	/**
	 * Sets whether block breaking is permitted for players in a {@link Round round}. (default: false)
	 * @param allowed whether block breaking is permitted for players in a {@link Round round}.
	 * @since 0.1.0
	 */
	public void setBlockBreakAllowed(boolean allowed){
		actions.put("block-break", allowed);
	}

	/**
	 * Retrieves whether hanging entity (e.g. paintings, item frames) breaking is permitted for players in a {@link Round round}. (default: false)
	 * @return whether hanging entity breaking is permitted for players in a {@link Round round}.
	 * @since 0.3.0
	 */
	public boolean isHangingBreakAllowed(){
		return actions.get("hanging-break");
	}

	/**
	 * Sets whether hanging entity (e.g. paintings, item frames) breaking is permitted for players in a {@link Round round}. (default: false)
	 * @param allowed whether hanging entity breaking is permitted for players in a {@link Round round}.
	 * @since 0.3.0
	 */
	public void setHangingBreakAllowed(boolean allowed){
		actions.put("hanging-break", allowed);
	}

	/**
	 * Retrieves whether players in a minigame may remove the item from an item frame by clicking on it. (default: false)
	 * @return whether players in a minigame may remove the item from an item frame by clicking on it.
	 * @since 0.3.0
	 */
	public boolean isItemFrameDamageAllowed(){
		return actions.get("item-frame-damage");
	}

	/**
	 * Sets whether players in a minigame may remove the item from an item frame by clicking on it. (default: false)
	 * @param allowed whether players in a minigame may remove the item from an item frame by clicking on it.
	 * @since 0.3.0
	 */
	public void setItemFrameDamageAllowed(boolean allowed){
		actions.put("item-frame-damage", allowed);
	}

	/**
	 * Retrieves whether block burning is permitted in worlds containing one or more arenas. (default: false)
	 * @return whether block burning is permitted in worlds containing one or more arenas.
	 * @since 0.1.0
	 */
	public boolean isBlockBurnAllowed(){
		return actions.get("block-burn");
	}

	/**
	 * Sets whether block burning is permitted in worlds containing one or more arenas. (default: false)
	 * @param allowed whether block burning is permitted in worlds containing one or more arenas.
	 * @since 0.1.0
	 */
	public void setBlockBurningAllowed(boolean allowed){
		actions.put("block-burn", allowed);
	}

	/**
	 * Retrieves whether block fading (e.g. leaves decaying) is permitted in worlds containing one or more arenas. (default: false)
	 * @return whether block fading (e.g. leaves decaying) is permitted in worlds containing one or more arenas.
	 * @since 0.1.0
	 */
	public boolean isBlockFadeAllowed(){
		return actions.get("block-fade");
	}

	/**
	 * Sets whether block fading (e.g. leaves decaying) is permitted in worlds containing one or more arenas. (default: false)
	 * @param allowed whether block fading (e.g. leaves decaying) is permitted in worlds containing one or more arenas.
	 * @since 0.1.0
	 */
	public void setBlockFadeAllowed(boolean allowed){
		actions.put("block-fade", allowed);
	}

	/**
	 * Retrieves whether block growing (e.g. reeds growing) is permitted in worlds containing one or more arenas. (default: false)
	 * @return whether block growing (e.g. reeds growing) is permitted in worlds containing one or more arenas.
	 * @since 0.1.0
	 */
	public boolean isBlockGrowAllowed(){
		return actions.get("block-grow");
	}

	/**
	 * Sets whether block growing (e.g. reeds growing) is permitted in worlds containing one or more arenas. (default: false)
	 * @param allowed whether block growing (e.g. reeds growing) is permitted in worlds containing one or more arenas.
	 * @since 0.1.0
	 */
	public void setBlockGrowAllowed(boolean allowed){
		actions.put("block-grow", allowed);
	}

	/**
	 * Retrieves whether block ignition is permitted in worlds containing one or more arenas. (default: false)
	 * @return whether block ignition is permitted in worlds containing one or more arenas.
	 * @since 0.1.0
	 */
	public boolean isBlockIgniteAllowed(){
		return actions.get("block-ignite");
	}

	/**
	 * Sets whether block ignition is permitted in worlds containing one or more arenas. (default: false)
	 * @param allowed whether block ignition is permitted in worlds containing one or more arenas.
	 * @since 0.1.0
	 */
	public void setBlockIgniteAllowed(boolean allowed){
		actions.put("block-ignite", allowed);
	}

	/**
	 * Retrieves whether block flowing is permitted in worlds containing one or more arenas. (default: true)
	 * @return whether block flowing is permitted in worlds containing one or more arenas.
	 * @since 0.1.0
	 */
	public boolean isBlockFlowAllowed(){
		return actions.get("block-flow");
	}

	/**
	 * Sets whether block flowing is permitted in worlds containing one or more arenas. (default: true)
	 * @param allowed whether block flowing is permitted in worlds containing one or more arenas.
	 * @since 0.1.0
	 */
	public void setBlockFlowAllowed(boolean allowed){
		actions.put("block-flow", allowed);
	}

	/**
	 * Retrieves whether block physics are permitted in worlds containing one or more arenas. (default: true)
	 * @return whether block physics are permitted in worlds containing one or more arenas.
	 * @since 0.1.0
	 */
	public boolean isBlockPhysicsAllowed(){
		return actions.get("block-physics");
	}

	/**
	 * Sets whether block ignition are physics in worlds containing one or more arenas. (default: true)
	 * @param allowed whether block physics are permitted in worlds containing one or more arenas.
	 * @since 0.3.0
	 */
	public void setBlockPhysicsAllowed(boolean allowed){
		actions.put("block-physics", allowed);
	}
	
	/**
	 * Sets whether block ignition are physics in worlds containing one or more arenas. (default: true)
	 * @deprecated This method is improperly named, but remains for the sake of reverse compatibility.
	 * You should instead use {@link ConfigManager#setBlockPhysicsAllowed(boolean)}.
	 * @param allowed whether block physics are permitted in worlds containing one or more arenas.
	 * @since 0.1.0
	 */
	@Deprecated
	public void setBlockPhyiscsAllowed(boolean allowed){
		setBlockPhysicsAllowed(allowed);
	}

	/**
	 * Retrieves whether pistons are permitted in worlds containing one or more arenas. (default: true)
	 * @return whether pistons are permitted in worlds containing one or more arenas.
	 * @since 0.1.0
	 */
	public boolean isBlockPistonAllowed(){
		return actions.get("block-piston");
	}

	/**
	 * Sets whether pistons are permitted in worlds containing one or more arenas. (default: true)
	 * @param allowed whether pistons are permitted in worlds containing one or more arenas.
	 * @since 0.1.0
	 */
	public void setBlockPistonAllowed(boolean allowed){
		actions.put("block-piston", allowed);
	}

	/**
	 * Retrieves whether block spreading (e.g. grass spreding to dirt blocks) are permitted in worlds containing one or more arenas. (default: false)
	 * @return whether block spreading (e.g. grass spreding to dirt blocks) are permitted in worlds containing one or more arenas.
	 * @since 0.1.0
	 */
	public boolean isBlockSpreadAllowed(){
		return actions.get("block-spread");
	}

	/**
	 * Sets whether block spreading (e.g. grass spreding to dirt blocks) are permitted in worlds containing one or more arenas. (default: false)
	 * @param allowed whether block spreading (e.g. grass spreding to dirt blocks) are permitted in worlds containing one or more arenas.
	 * @since 0.1.0
	 */
	public void setBlockSpreadAllowed(boolean allowed){
		actions.put("block-spread", allowed);
	}

	/**
	 * Retrieves whether entity explosions are permitted in worlds containing one or more arenas. (default: false)
	 * @return whether entity explosions are permitted in worlds containing one or more arenas.
	 * @since 0.3.0
	 */
	public boolean isEntityExplosionsAllowed(){
		return actions.get("entity-explode");
	}

	/**
	 * Sets whether entity explosions are permitted in worlds containing one or more arenas. (default: false)
	 * @param allowed whether entity explosions are permitted in worlds containing one or more arenas.
	 * @since 0.3.0
	 */
	public void setEntityExplosionsAllowed(boolean allowed){
		actions.put("entity-explode", allowed);
	}

	/**
	 * Retrieves the {@link Class class} object used to store information about players in minigame rounds. (default: {@link MGPlayer MGPlayer.class}
	 * @return the static class to use for player storage (e.g. CustomPlayer.class).
	 * @since 0.1.0
	 */
	public Class<? extends MGPlayer> getPlayerClass(){
		return playerClass;
	}

	/**
	 * Sets the {@link Class class} object used to store information about players in minigame rounds. (default: {@link MGPlayer MGPlayer.class})
	 * This may be used to add additional fields to MGLib's default {@link MGPlayer} class.
	 * @param clazz the static class to use for player storage (e.g. CustomPlayer.class).
	 * @since 0.1.0
	 */
	public void setPlayerClass(Class<? extends MGPlayer> clazz){
		this.playerClass = clazz;
	}

	/**
	 * Retrieves the default {@link GameMode gamemode} for players entering minigame rounds. (default: {@link GameMode#SURVIVAL})
	 * @return the default {@link GameMode gamemode} for players entering minigame rounds.
	 * @since 0.1.0
	 */
	public GameMode getDefaultGameMode(){
		return gameMode;
	}

	/**
	 * Sets the default {@link GameMode gamemode} for players entering minigame rounds. (default: {@link GameMode#SURVIVAL}
	 * @param gameMode the default {@link GameMode gamemode} for players entering minigame rounds.
	 * @since 0.1.0
	 */
	public void setDefaultGameMode(GameMode gameMode){
		this.gameMode = gameMode;
	}

	/**
	 * Retrieves whether PvP is allowed by default. (default: true)
	 * @return whether PvP is allowed by default.
	 * @since 0.1.0
	 */
	public boolean isPvPAllowed(){
		return pvp;
	}

	/**
	 * Sets whether PvP is allowed by default. (default: true)
	 * @param allowed whether PvP is allowed by default.
	 * @since 0.1.0
	 */
	public void setPvPAllowed(boolean allowed){
		this.pvp = allowed;
	}

	/**
	 * Retrieves whether players in rounds may receive damage. (default: true)
	 * @return whether players in rounds may receive damage.
	 * @since 0.1.0
	 */
	public boolean isDamageAllowed(){
		return damage;
	}

	/**
	 * Sets whether players in rounds may receive damage by default. (default: true)
	 * @param allowed whether players in rounds may receive damage by default.
	 * @since 0.1.0 
	 */
	public void setDamageAllowed(boolean allowed){
		this.damage = allowed;
	}

	/**
	 * Retrieves whether rollback is enabled by default. (default: true)
	 * @return whether rollback is enabled by default.
	 * @since 0.2.0
	 */
	public boolean isRollbackEnabled(){
		return rollback;
	}

	/**
	 * Sets whether rollback is enabled by default. (default: true)
	 * @param enabled whether rollback is enabled by default.
	 * @since 0.2.0
	 */
	public void setRollbackEnabled(boolean enabled){
		this.rollback = enabled;
	}

	/**
	 * Retrieves whether spectators' names are displayed on lobby signs. (defualt: true)
	 * @return whether spectators' names are displayed on lobby signs.
	 * @since 0.2.0
	 */
	public boolean areSpectatorsOnLobbySigns(){
		return spectatorsOnSigns;
	}

	/**
	 * Sets whether spectators' names are displayed on lobby signs. (default: true)
	 * @param displayed whether spectators' names are displayed on lobby signs.
	 * @since 0.2.0
	 */
	public void setSpectatorsOnLobbySigns(boolean displayed){
		this.spectatorsOnSigns = displayed;
	}

	/**
	 * Retrieves whether spectators are permitted to fly. (default: true)
	 * This will be overridden if allow-flight is set to false in the server.properties file,
	 * or if {@link ConfigManager#isUsingVanillaSpectating()} returns true.
	 * @return whether spectators are permitted to fly.
	 * @since 0.2.0
	 */
	public boolean isSpectatorFlightAllowed(){
		return spectatorFlight;
	}

	/**
	 * Sets whether spectators are permitted to fly. (default: true)
	 * This will be overridden if allow-flight is set to false in the server.properties file,
	 * or if {@link ConfigManager#isUsingVanillaSpectating()} returns true.
	 * @param allowed whether spectators are permitted to fly.
	 * @since 0.2.0
	 */
	public void setSpectatorFlightAllowed(boolean allowed){
		this.spectatorFlight = allowed;
	}

	/**
	 * Retrieves whether players are permitted to damage teammates. (default: true)
	 * @return whether players are permitted to damage teammates.
	 * @since 0.3.0
	 */
	public boolean isTeamDamageAllowed(){
		return teamDamage;
	}

	/**
	 * Sets whether players are permitted to damage teammates. (default: true)
	 * @param allowed whether players are permitted to damage teammates.
	 * @since 0.3.0
	 */
	public void setTeamDamageAllowed(boolean allowed){
		this.teamDamage = allowed;
	}

	/**
	 * Retrieves the locale to fall back to if the one defined in the MGLib config cannot be loaded. (default: enUS)
	 * @return the locale to fall back to if the one defined in the MGLib config cannot be loaded.
	 * @since 0.3.0
	 */
	public String getDefaultLocale(){
		return locale;
	}

	/**
	 * Sets the locale to fall back to if the one defined in the MGLib config cannot be loaded. (default: enUS)
	 * @param locale the locale to fall back to if the one defined in the MGLib config cannot be loaded.
	 * @since 0.3.0
	 */
	public void setDefaultLocale(String locale){
		this.locale = locale;
	}

	/**
	 * Retrieves whether players are sent to a random spawn when entered into an arena. (default: true)
	 * @return whether players should be sent to a random spawn.
	 * @since 0.3.0
	 */
	public boolean isRandomSpawning(){
		return randomSpawns;
	}

	/**
	 * Sets whether players are sent to a random spawn when entered into an arena. (default: true)
	 * When false, the first player to join will be sent to spawn 0, the second to spawn 1, etc.
	 * @param random whether players should be sent to a random spawn.
	 * @since 0.3.0
	 */
	public void setRandomSpawning(boolean random){
		this.randomSpawns = random;
	}

	/**
	 * Retrieves whether Bukkit's {@link PlayerDeathEvent} will be overridden for players participating in minigame rounds. (default: false)
	 * If true, the death event will be cancelled and a custom MGLib event will be thrown instead.
	 * @return whether Bukkit's {@link PlayerDeathEvent} will be overridden.
	 * @since 0.3.0
	 */
	public boolean isOverrideDeathEvent(){
		return overrideDeathEvent;
	}

	/**
	 * Sets whether Bukkit's {@link PlayerDeathEvent} will be overridden for players participating in minigame rounds. (default: false)
	 * If true, the death event will be cancelled and a custom MGLib event will be thrown instead.
	 * @param override whether Bukkit's {@link PlayerDeathEvent} will be overridden.
	 * @since 0.3.0
	 */
	public void setOverrideDeathEvent(boolean override){
		this.overrideDeathEvent = override;
	}

	/**
	 * Retrieves whether hunger should drain from players in rounds. (default: false)
	 * @return whether hunger should drain from players in rounds.
	 * @since 0.3.0
	 */
	public boolean isHungerEnabled(){
		return hunger;
	}

	/**
	 * Retrieves whether hunger should drain from players in rounds. (default: false)
	 * @param enabled whether hunger should drain from players in rounds.
	 * @since 0.3.0
	 */
	public void setHungerEnabled(boolean enabled){
		this.hunger = enabled;
	}

	/**
	 * Retrieves whether chat should be handled on a per-round basis (e.g. players in an arena only see messages sent by players in the same arena).
	 * (default: true)
	 * @return whether chat should be handled on a per-round basis (e.g. players in an arena only see messages sent by players in the same arena).
	 * @since 0.3.0
	 */
	public boolean isPerRoundChatEnabled(){
		return perRoundChat;
	}

	/**
	 * Sets whether chat should be handled on a per-round basis (e.g. players in an arena only see messages sent by players in the same arena).
	 * (default: true)
	 * @param enabled whether chat should be handled on a per-round basis (e.g. players in an arena only see messages sent by players in the same arena).
	 * @since 0.3.0
	 */
	public void setPerRoundChatEnabled(boolean enabled){
		this.perRoundChat = enabled;
	}



	/**
	 * Retrieves whether teams in a round should have separate chat channels. (default: false)
	 * (default: false)
	 * @return whether teams in a round should have separate chat channels.
	 * @since 0.3.0
	 */
	public boolean isTeamChatEnabled(){
		return teamChat;
	}

	/**
	 * Sets whether teams in a round should have separate chat channels.
	 * (default: false)
	 * @param enabled whether teams in a round should have separate chat channels.
	 * @since 0.3.0
	 */
	public void setTeamChatEnabled(boolean enabled){
		this.teamChat = enabled;
	}

	/**
	 * Retrieves whether mob spawning is permitted in worlds containing an arena. (default: true)
	 * @return whether mob spawning is permitted in worlds containing an arena.
	 * @since 0.3.0
	 */
	public boolean isMobSpawningAllowed(){
		return mobSpawning;
	}

	/**
	 * Sets whether mob spawning is permitted in worlds containing an arena. (default: true)
	 * @param allowed whether mob spawning is permitted in worlds containing an arena.
	 * @since 0.3.0
	 */
	public void setMobSpawningAllowed(boolean allowed){
		this.mobSpawning = allowed;
	}

	/**
	 * Retrieves whether entities are permitted to target players in arenas. (default: false)
	 * @return whether entities are permitted to target players in arenas.
	 * @since 0.3.0
	 */
	public boolean isEntityTargetingEnabled(){
		return targeting;
	}

	/**
	 * Sets whether entities are permitted to target players in arenas. (default: false)
	 * @param enabled whether entities are permitted to target players in arenas.
	 * @since 0.3.0
	 */
	public void setEntityTargetingEnabled(boolean enabled){
		this.targeting = enabled;
	}

	/**
	 * Retrieves whether spectators are placed in a separate chat channel from active players. (default: true)
	 * @return whether spectators are placed in a separate chat channel from active players.
	 * @since 0.3.0
	 */
	public boolean isSpectatorChatSeparate(){
		return spectatorChat;
	}

	/**
	 * Sets whether spectators are placed in a separate chat channel from active players. (default: true)
	 * @param separate whether spectators are placed in a separate chat channel from active players.
	 * @since 0.3.0
	 */
	public void setSpectatorChatSeparate(boolean separate){
		this.spectatorChat = separate;
	}
	
	/**
	 * Retrieves whether players are made vanilla spectators when {@link MGPlayer#setSpectating(boolean)} is called. (default: true)
	 * If false, the player will be manually made invisible and flying.
	 * @return whether players are made vanilla spectators when {@link MGPlayer#setSpectating(boolean)} is called.
	 * @since 0.3.0
	 */
	public boolean isUsingVanillaSpectating(){
		return vanillaSpectating;
	}
	
	/**
	 * Sets whether players are made vanilla spectators when {@link MGPlayer#setSpectating(boolean)} is called. (default: true)
	 * If false, the player will be manually made invisible and flying.
	 * @param vanillaSpectating whether players are made vanilla spectators when {@link MGPlayer#setSpectating(boolean)} is called.
	 * @since 0.3.0
	 */
	public void setUsingVanillaSpectating(boolean vanillaSpectating){
		this.vanillaSpectating = vanillaSpectating;
	}

}
