package org.gauri.assignment.gameofthree.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix="game")  
@Component
public class GameProperties {

	private String player2port;  
	private String playerName;

	public String getPlayer2port() {
		return player2port;  
	}

	public void setPlayer2port(String player2port) {
		this.player2port = player2port;  
	} 

	
	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	
	
}
