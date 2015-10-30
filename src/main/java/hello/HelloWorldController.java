package hello;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello-world")
public class HelloWorldController {

	private static final String template = "Hello, %s";
	private static final AtomicLong counter = new AtomicLong();

	@RequestMapping(method=GET)
	public @ResponseBody Greeting sayHello(
			@RequestParam(value = "name", required = false, defaultValue = "stranger") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template,
				name));
	}
}
