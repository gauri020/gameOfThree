package org.gauri.assignment.gameofthree.model;

public class Player {

	private String playerName;
	private boolean winner;
	
	public Player() {
	}
	
	public Player(String playerName, boolean winner) {
		this.playerName = playerName;
		this.winner = winner;
	}
	
	public String getPlayerName() {
		return playerName;
	} 
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public boolean isWinner() {
		return winner;
	}
	public void setWinner(boolean winner) {
		this.winner = winner;
	}
	
	@Override
	public String toString() {
		return "Player [playerName=" + playerName + ", winner=" + winner + "]";
	}
	
	
	
}
