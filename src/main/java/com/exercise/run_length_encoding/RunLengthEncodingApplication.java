package com.exercise.run_length_encoding;

import com.exercise.run_length_encoding.service.RunLengthEncodingService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class RunLengthEncodingApplication {

	private final RunLengthEncodingService runLengthEncodingService;

	public static void main(String[] args) {
		SpringApplication.run(RunLengthEncodingApplication.class, args);
	}

	@Bean
	public ApplicationRunner startupRunner() {
		String text = "aaaaaaaaaaaaaaaaaaaaa bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb Hello World! zzzzzzzzzzzzzzzzzzzzzzzz this is a test! Let's try!!";
		return args -> {
			System.out.println("------------------------------------------------------------------------");
			System.out.println("WELCOME TO RUN LENGTH ENCODING ALGORITHM IMPLEMENTATION");
			System.out.println("Using implementation: " + runLengthEncodingService.implementationName());
			System.out.println("You can change the implementation in the application.yaml");
			System.out.println("------------------------------------------------------------------------");
			String compressedText = runLengthEncodingService.printInfoCompress(text);
			System.out.println();
			runLengthEncodingService.printInfoDecompress(compressedText);
		};
	}
}
