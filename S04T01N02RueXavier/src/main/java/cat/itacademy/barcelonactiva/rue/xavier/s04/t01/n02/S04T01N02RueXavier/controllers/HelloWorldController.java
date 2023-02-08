package cat.itacademy.barcelonactiva.rue.xavier.s04.t01.n02.S04T01N02RueXavier.controllers;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	private static final String TEMPLATE = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	
	@GetMapping("/HelloWorld")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, name));

	}
	
	@GetMapping(value={"/HelloWorld","/HelloWorld/{nombre}"})
	public Greeting greeting2 (@PathVariable Optional <String> nombre) {
		if(nombre.isEmpty())
			nombre=Optional.of("Unkown");
		return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, nombre));
	}

}
