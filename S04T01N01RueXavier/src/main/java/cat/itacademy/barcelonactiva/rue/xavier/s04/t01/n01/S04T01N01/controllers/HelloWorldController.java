package cat.itacademy.barcelonactiva.rue.xavier.s04.t01.n01.S04T01N01.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	private static final String TEMPLATE = "hello ,%s";
	private final AtomicLong counter = new AtomicLong();	
	
	@GetMapping("/HelloWorld")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, name)); 
	}
	
	
	@GetMapping(value = {"/HelloWorld2", "/HelloWorld2/{name}"})
	public Greeting greeting2(@PathVariable(required=false) String name) {
		if (name == null){
			name = "world";
		} 
				
		return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, name)); 
	}

}
