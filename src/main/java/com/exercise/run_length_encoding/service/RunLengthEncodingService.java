package com.exercise.run_length_encoding.service;

public interface RunLengthEncodingService {
    String compress(String text);
    String decompress(String compressedText);
    String implementationName();

    default String printInfoCompress(String text) {
        System.out.println("TEXT TO COMPRESS:\n" + text);
        long start = System.nanoTime();
        String compressedText = compress(text);
        long end = System.nanoTime();
        long durationNs = end - start;
        System.out.println("COMPRESSED TEXT:\n" + compressedText);
        System.out.println("Execution time: " + durationNs + " ns (" + (durationNs / 1_000_000.0) + " ms)");
        return compressedText;
    }

    default void printInfoDecompress(String compressedText) {
        System.out.println("COMPRESSED TEXT:\n" + compressedText);
        long start = System.nanoTime();
        String decompressedText = decompress(compressedText);
        long end = System.nanoTime();
        long durationNs = end - start;
        System.out.println("DECOMPRESSED TEXT:\n" + decompressedText);
        System.out.println("Execution time: " + durationNs + " ns (" + (durationNs / 1_000_000.0) + " ms)");
    }
}
