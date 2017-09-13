package org.gauri.assignment.gameofthree.controller;

import java.time.LocalDateTime;


import org.gauri.assignment.gameofthree.model.Move;
import org.gauri.assignment.gameofthree.service.GameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Preconditions;

@RestController
@RequestMapping("/game")
public class GameController {  
	private static Logger LOG = LoggerFactory.getLogger(GameController.class);
	
	@Autowired
	GameService gameService;
	
	@Value("${game.playerName}")
	private String playerName;
	
	@RequestMapping(value="/head",method = RequestMethod.HEAD)
	public ResponseEntity<String> headRequest(){
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@RequestMapping("/play") 
	public String play(@RequestParam(value="number",required=true)String receivedNumber,
							@RequestParam(value="playerName",required=false)String playerName){		
		LOG.info(" GAME OF THREE started with player : {} at {} with number : {} ." 
										,playerName,LocalDateTime.now(),receivedNumber); 
		 Preconditions.checkArgument(Integer.parseInt(receivedNumber)>1,"Invalid input.");
		 
		String player = gameService.play(Integer.parseInt(receivedNumber),playerName);
//		if(player.equals(playerName)){ 
//			LOG.info(playerName+" won");
//		}else{
//			LOG.info("player 2 won");
//		}
		LOG.info(player+" won");
		return player;
	}
	
	@RequestMapping("/calculateNumber")
	public ResponseEntity<Move> calculateNumber(@RequestParam(value="number" , required=true)int value, @RequestParam(value="addedNumber", required=false) Integer addedNumber){	
		LOG.info("Calling  player {} for number : {}",playerName,value); 	
		return new ResponseEntity<Move>(gameService.checkNumberAndAdd(value),HttpStatus.OK);
	}
	
	
	//new
	@RequestMapping("/playNextMove")
	public ResponseEntity<Move> playNextMove(@RequestParam(value="number" , required=true)int receivedNumber, @RequestParam(value="addedNumber", required=false) Integer addedNumber){	
		LOG.info("Calling player {} for number : {}",playerName,receivedNumber); 	
		Move move = new Move(receivedNumber,addedNumber,0,null);
		LOG.info("move"+move.toString()); 	

		return new ResponseEntity<Move>(gameService.playNextMove(move),HttpStatus.OK);
	}
	@RequestMapping("/playNextMove1")
	public ResponseEntity<Move> playNextMove1(@RequestParam(value="number" , required=true)int receivedNumber, @RequestParam(value="addedNumber", required=false) Integer addedNumber){	
		LOG.info("Calling player {} for number : {}",playerName,receivedNumber); 	
		
		Move move = new Move(receivedNumber,addedNumber,0,null);
		LOG.info("move"+move.toString()); 	

		return new ResponseEntity<Move>(gameService.playNextMove1(move),HttpStatus.OK);
	}
	
	
	 @ExceptionHandler(RuntimeException.class)
	 public ResponseEntity<String> handleException(Exception ex) {
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);     
	    }
}
