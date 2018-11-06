package com.packt.project1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.apache.log4j.Logger;


@Controller
@RequestMapping("/")
public class OcenaController {
	
	 final static Logger logger = Logger.getLogger(OcenaController.class);

	   @Autowired
	   OcenaRepository ocenaRepository;
	   
	   @RequestMapping(value = "/ocena", method = RequestMethod.GET)
	   @ResponseBody
	   public List<Ocena> findCzynnoscAll() { 
		   logger.info("hej info");
		   logger.debug("hej debug");
	       return (List<Ocena>) ocenaRepository.findAll();
	   }
	   @RequestMapping(value = "/czynnosc/{id}", method = RequestMethod.GET)
	   @ResponseBody
	   public Ocena findCzynnoscId(@PathVariable("id") Integer id) {
		   logger.info("hej info");
		   logger.debug("hej debug");
	       Optional<Ocena> x = ocenaRepository.findById(id);
	       if(x.isPresent() == false)
	    	   throw new NotFoundException();
	       return x.get();
	   }
	 
	   @RequestMapping(value = "/czynnosc/{id}", method = RequestMethod.PUT)
	   @ResponseStatus(HttpStatus.OK)
	   public void update(@PathVariable( "id" ) Integer id, @RequestBody Ocena ocena) {
		   logger.info("hej info");
		   logger.debug("hej debug");
		   if(! ocenaRepository.existsById(id)) {
			   throw new NotFoundException();
		   }
		   if(ocena == null || ocena.getId() != id ) {
			   throw new BadRequestException();
		   }
	       ocenaRepository.save(ocena);
	   }
	 
	   @RequestMapping(value = "/ocena/{id}", method = RequestMethod.DELETE)
	   @ResponseStatus(HttpStatus.OK)
	   public void deleteOcena(@PathVariable("id") Integer id) {
		   logger.info("hej info");
		   logger.debug("hej debug");
		   if(! ocenaRepository.existsById(id)) {
			   throw new NotFoundException();
		   }
	       ocenaRepository.deleteById(id);
	   }
	
}
