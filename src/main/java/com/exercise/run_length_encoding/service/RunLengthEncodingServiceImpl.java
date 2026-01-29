package com.exercise.run_length_encoding.service;

public class RunLengthEncodingServiceImpl implements RunLengthEncodingService {
    @Override
    public String compress(String text) {
        StringBuilder sb = new StringBuilder();
        char[] textArray = text.toCharArray();
        int i = 0;
        int len = textArray.length;
        while (i < len) {
            char c = textArray[i];
            if (c == ' ') {
                sb.append(" ");
                i++;
                continue;
            }
            int count = 1;
            for (int j = i + 1; j < len && j < i + 9 && c == textArray[j] ; j++) {
                count++;
            }
            if(count == 1 && !Character.isDigit(c)){
                sb.append(c);
            } else {
                sb.append(count).append(c);
            }
            i += count;
        }
        return sb.toString();
    }

    @Override
    public String decompress(String compressedText) {
        StringBuilder sb = new StringBuilder();
        char[] compressedTextArray = compressedText.toCharArray();
        int i = 0;
        while (i < compressedTextArray.length) {
            char c = compressedTextArray[i];
            if(Character.isDigit(c) && i + 1 < compressedTextArray.length){
                int count = compressedTextArray[i] - '0';
                char nextChar = compressedTextArray[i+1];
                for(int j = 0; j < count; j++) {
                    sb.append(nextChar);
                }
                i+=2;
            } else {
                sb.append(c);
                i++;
            }
        }
        return sb.toString();
    }

    @Override
    public String implementationName() {
        return "Simple";
    }
}
