package org.gauri.assignment.gameofthree.service;

import org.gauri.assignment.gameofthree.model.Move;
import org.gauri.assignment.gameofthree.model.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class GameService {
	private static Logger LOG = LoggerFactory.getLogger(GameService.class);

	@Value("${game.player2port}")
	private String player2port;
	
	
	@Value("${game.playerName}")
	private String playerName;
	
  //TODO get value from configuration for url and port  
	public String play(int receivedNumber,String playerName) {
		LOG.info("playerName "+playerName);
		
		    ResponseEntity<Move> response= null;
//		    Move move = new Move();
//		    move.setPlayer(new Player(playerName,false));
		   UriComponents uri = UriComponentsBuilder
		                			.fromHttpUrl("http://localhost:{port}/gameofthree/game/playNextMove")
		                			.queryParam("number", receivedNumber)
		                			.buildAndExpand(player2port); 
				final String url = uri.toUriString();
				
				LOG.info("Url for other player {}",url);		
				RestTemplate restTemplate = new RestTemplate(); 
				
				//HttpEntity<Move> entity = new HttpEntity<Move>(move);
				response = restTemplate.exchange(url,HttpMethod.GET,null,Move.class);
				
//	    if(response.getBody().getResultingNumber()==1){
//		    	return "PLAYER2";
//		    }else{
//		    	return playerName;
//		    }
				
				return response.getBody().getPlayer().getPlayerName();
	}
//TODO generate comment
	public Move playNextMove(Move move) throws RestClientException {
		LOG.info("playerName "+playerName);

		Move newMove = checkNumberAndAdd(move.getReceivedNumber());
		if(newMove.getResultingNumber()!=1){
		UriComponents uri = UriComponentsBuilder
                			.fromHttpUrl("http://localhost:{port}/gameofthree/game/playNextMove1")
                			.queryParam("number", newMove.getResultingNumber())
                			.buildAndExpand(player2port); 
		final String url = uri.toUriString();
		
		LOG.info("Url for other player {}",url);		
		RestTemplate restTemplate = new RestTemplate(); 
		HttpEntity<Move> entity = new HttpEntity<Move>(newMove);

		ResponseEntity<Move> response = restTemplate.exchange(url,HttpMethod.GET,null,Move.class );
		newMove = response.getBody();
		}
		
//		if(newMove.getPlayer()!=null){
//			newMove.getPlayer().setPlayerName(playerName);
//			newMove.getPlayer().setWinner(true);
//		}
//		else{
//			Player player = new Player(playerName,true);
//			newMove.setPlayer(player);
//		}
		

		
		 return newMove;
	}

	public Move playNextMove1(Move move) throws RestClientException {
		LOG.info("playerName "+playerName);

		Move newMove = checkNumberAndAdd(move.getReceivedNumber());
		if(newMove.getResultingNumber()!=1){
		UriComponents uri = UriComponentsBuilder
                			.fromHttpUrl("http://localhost:{port}/gameofthree/game/playNextMove")
                			.queryParam("number", newMove.getResultingNumber())
                			.buildAndExpand(player2port); 
		final String url = uri.toUriString();
		
		LOG.info("Url for other player {}",url);		
		RestTemplate restTemplate = new RestTemplate(); 
		HttpEntity<Move> entity = new HttpEntity<Move>(newMove);

		ResponseEntity<Move> response =  restTemplate.exchange(url,HttpMethod.GET,null,Move.class );
		newMove = response.getBody();

		}
		
//		if(newMove.getPlayer()!=null){
//			newMove.getPlayer().setPlayerName(playerName);
//			newMove.getPlayer().setWinner(true);
//		}
//		else{
//			Player player = new Player(playerName,true);
//			newMove.setPlayer(player);
//		}

		
		return newMove;
	}
	
	  
	//logic
	public Move checkNumberAndAdd(int recievedNumber) {		
		int remainder = recievedNumber % 3;
		int resultingNumbber=0;
		Move move = new Move();
		move.setReceivedNumber(recievedNumber); 
		if(remainder==0){
			resultingNumbber= recievedNumber/3;
			move.setAddedNumber(0); 
		}else if(remainder==1){
			resultingNumbber= ((recievedNumber-1)/3);
			move.setAddedNumber(-1); 

		}else if(remainder==2){
			resultingNumbber= ((recievedNumber+1)/3);
			move.setAddedNumber(1); 
		}
		move.setResultingNumber(resultingNumbber);
		if(move.getPlayer()!=null){
			move.getPlayer().setPlayerName(playerName);
			move.getPlayer().setWinner(true);
		}
		else{
			Player player = new Player(playerName,true);
			move.setPlayer(player);
		}
		return move;
	}	
	
//	private boolean shouldProcessedFurther(ResponseEntity<Move> response){  
//	LOG.debug(response.getBody().toString()); 
//	if(response.getBody().getResultingNumber()==1){
//		return false;
//	}else if((checkNumberAndAdd(response.getBody().getResultingNumber()).getResultingNumber())==1){   
//		return false;
//	}else {
//		return true;
//	}
//}

//	public int divideByThreeRemainder(int number){
//		return  number % 3;
//		
//	}
	
	
	
}


