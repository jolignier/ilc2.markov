package app;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import markov.MarkovChain;

/**
 * Lorem Ipsum is simply dummy text of the printing and typesetting industry.
 * Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,
 * when an unknown printer took a galley of type and scrambled it to make a
 * type specimen book. It has survived not only five centuries, but also the leap
 * into electronic typesetting, remaining essentially unchanged. It was
 * popularised in the 1960s with the release of Letraset sheets containing Lorem
 * Ipsum passages, and more recently with desktop publishing software like
 * Aldus PageMaker including versions of Lorem Ipsum
 */
public class MarkovApp {

	
	public static void main(String[] args) throws Exception {
        String sentences = readFileAsString("./target/classes/VictorHugo_LesMiserables-II-Cosette.txt");
        System.out.println(sentences);
        
        MarkovChain markov = new MarkovChain(3);
        markov.learn(sentences);
        
        System.out.println("Generation :\n");
        System.out.println(markov.generateMarkov(6));
        System.out.println(markov.generateMarkov(9));
        System.out.println(markov.generateMarkov(12));
	}

    public static String readFileAsString(String fileName) throws Exception {
        String data = ""; 
        Path path = Paths.get(fileName); 
        data = Files.readString(path, StandardCharsets.UTF_8); 
        return data; 
    } 
    
}
