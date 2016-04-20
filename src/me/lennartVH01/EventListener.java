package me.lennartVH01;

import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerQuitEvent;

public class EventListener implements Listener{
	public Main plugin;
	public void initialize(Main plugin) {
		this.plugin = plugin;
		
	}
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e){
		AbbaTools.leave(e.getPlayer().getUniqueId());
	}
	
	@EventHandler(ignoreCancelled = true)
	public void onChestOpen(InventoryOpenEvent e){
		if(e.getInventory().getType() == InventoryType.CHEST){
			AbbaTools.onChestOpen(e);
		}
	}
	
	@EventHandler(ignoreCancelled = true)
	public void onSignPlace(SignChangeEvent e){
		AbbaTools.onSignPlace(e);
	}
	
	@EventHandler(ignoreCancelled = true)
	public void onSignBreak(BlockBreakEvent e){
		Block brokenBlock = e.getBlock();
		if(BlockUtils.isSign(brokenBlock)){
			AbbaTools.onSignBreak(e);
		}
	}
}
