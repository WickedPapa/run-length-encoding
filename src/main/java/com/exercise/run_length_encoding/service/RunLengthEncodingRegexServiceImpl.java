package com.exercise.run_length_encoding.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RunLengthEncodingRegexServiceImpl implements RunLengthEncodingService {

    private static final Pattern COMPRESS_PATTERN = Pattern.compile("(.)\\1*");

    private static final Pattern DECOMPRESS_PATTERN = Pattern.compile("(\\d)(.)");

    @Override
    public String compress(String text) {
        StringBuilder sb = new StringBuilder();
        Matcher matcher = COMPRESS_PATTERN.matcher(text);

        while (matcher.find()) {
            String group = matcher.group();
            char c = group.charAt(0);
            int length = group.length();

            int i = 0;
            while (i < length) {
                int chunk = Math.min(9, length - i);
                if (chunk == 1 && !Character.isDigit(c)) {
                    sb.append(c);
                } else {
                    sb.append(chunk).append(c);
                }
                i+=chunk;
            }
        }

        return sb.toString();
    }

    @Override
    public String decompress(String compressedText) {
        StringBuilder sb = new StringBuilder();
        Matcher matcher = DECOMPRESS_PATTERN.matcher(compressedText);
        int lastEnd = 0;

        while (matcher.find()) {
            sb.append(compressedText, lastEnd, matcher.start());

            int count = matcher.group(1).charAt(0) - '0';
            char c = matcher.group(2).charAt(0);

            for (int i = 0; i < count; i++) {
                sb.append(c);
            }

            lastEnd = matcher.end();
        }

        sb.append(compressedText.substring(lastEnd));
        return sb.toString();
    }

    @Override
    public String implementationName() {
        return "Regex";
    }
}
