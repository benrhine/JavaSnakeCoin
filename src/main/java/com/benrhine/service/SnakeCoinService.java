package com.benrhine.service;

import com.benrhine.domain.GuavaBlock;
import com.benrhine.domain.JavaBlock;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SnakeCoinService {

    public GuavaBlock createGenesisGuavaBlock() {
        final String now = new SimpleDateFormat("yyyyMMdd-HH:mm:ss.SSS").format(new Date());
        return new GuavaBlock(0, now, "Genesis Block", "0");
    }

    public GuavaBlock nextGuavaBlock(final GuavaBlock previousBlock) {
        final Integer currentIndex = previousBlock.getIndex() + 1;
        final String currentTimestamp = new SimpleDateFormat("yyyyMMdd-HH:mm:ss.SSS").format(new Date());
        final String currentData = "Hey! Im block " + currentIndex.toString();
        final String currentHash = previousBlock.getHash();

        return new GuavaBlock(currentIndex, currentTimestamp, currentData, currentHash);
    }

    public JavaBlock createGenesisJavaBlock() {
        final String now = new SimpleDateFormat("yyyyMMdd-HH:mm:ss.SSS").format(new Date());
        return new JavaBlock(0, now, "Genesis Block", "0");
    }

    public JavaBlock nextJavaBlock(final JavaBlock previousBlock) {
        final Integer currentIndex = previousBlock.getIndex() + 1;
        final String currentTimestamp = new SimpleDateFormat("yyyyMMdd-HH:mm:ss.SSS").format(new Date());
        final String currentData = "Hey! Im block " + currentIndex.toString();
        final String currentHash = previousBlock.getHash();

        return new JavaBlock(currentIndex, currentTimestamp, currentData, currentHash);
    }
}
