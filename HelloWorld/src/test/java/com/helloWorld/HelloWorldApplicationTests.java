package com.helloWorld;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloWorldApplicationTests {
	
		@Value("${local.server.port}")
	    private int port;

	    @Autowired
	    private TestRestTemplate restTemplate;

	    @Test
	    public void testGetHello() {
	        // Make a GET request to the endpoint and store the response in a String
	        String response = restTemplate.getForObject("http://localhost:" + port + "/greetapi/v1/hello", String.class);

	        // Assert that the response is equal to "hello World !!!"
	        assertThat(response).isEqualTo("hello World !!!");
	    }
	
	    @Test
	    public void testGetHelloWithName()
	    {
	    	String name="Shivam";
	    	String expectedres="hello Shivam !!!";
	    	String response=restTemplate.getForObject("http://localhost:" + port + "/greetapi/v1/hellowithname?name="+name, String.class);
	    	assertThat(response).isEqualTo(expectedres);
	    }
}
