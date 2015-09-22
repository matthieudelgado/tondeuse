package com.matthieudelgado.xebia.tondeuse.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.matthieudelgado.xebia.tondeuse.input.MowItNowFileExecutor;

public class Main {

	public static void main(String[] args) {
		try (Stream<Path> stream = Files.find(
				Paths.get("src/main/resources/com/matthieudelgado/xebia"), 1, 
				(path, attr) -> String.valueOf(path).endsWith(".test"))) {
			stream.forEach(path -> MowItNowFileExecutor.simulerFichier(path));
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
