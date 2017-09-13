package org.gauri.assignment.gameofthree.model;

public class Move {
	
	private int receivedNumber;
	private Integer addedNumber;  
	private int resultingNumber;  
	private Player player;
	
	
	
	public Move() {
	}

	public Move(int receivedNumber, Integer addedNumber, int resultingNumber, Player player) {
		this.receivedNumber = receivedNumber;
		this.addedNumber = addedNumber;
		this.resultingNumber = resultingNumber;
		this.player = player;
	}

	public int getReceivedNumber() {
		return receivedNumber; 
	}

	public void setReceivedNumber(int receivedNumber) {
		this.receivedNumber = receivedNumber;
	}

	public Integer getAddedNumber() {
		return addedNumber;
	}

	public void setAddedNumber(Integer addedNumber) {
		this.addedNumber = addedNumber;
	}

	public int getResultingNumber() {
		return resultingNumber;
	}

	public void setResultingNumber(int resultingNumber) {
		this.resultingNumber = resultingNumber;
	}
	

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	public String toString() {
		return "Move [receivedNumber=" + receivedNumber + ", addedNumber=" + addedNumber + ", resultingNumber="
				+ resultingNumber + ", player=" + player + "]";
	}
	
	
	
}
