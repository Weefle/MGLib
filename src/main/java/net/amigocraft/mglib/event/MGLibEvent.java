/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 Maxim Roncacé
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package net.amigocraft.mglib.event;

import net.amigocraft.mglib.Main;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class MGLibEvent extends Event {

	private static HandlerList handlers = new HandlerList();

	protected String plugin;

	/**
	 * Creates a new instance of this event.
	 * @param plugin the name of the plugin involved in this {@link MGLibEvent}
	 * @since 0.1.0
	 */
	public MGLibEvent(String plugin){
		this.plugin = plugin;
	}

	/**
	 * Retrieves the name of the plugin involved in this {@link MGLibEvent}.
	 * @return the name of the plugin involved in this {@link MGLibEvent}
	 * @since 0.1.0
	 */
	public String getPlugin(){
		return plugin;
	}

	public HandlerList getHandlers(){
		return handlers;
	}

	public static HandlerList getHandlerList(){
		return handlers;
	}

	/**
	 * Unsets all static objects in this class.
	 * This method will not do anything unless MGLib is in the process of disabling.
	 * @since 0.1.0
	 */
	public static void uninitialize(){
		if (Main.isDisabling()){
			handlers = null;
		}
	}

}
