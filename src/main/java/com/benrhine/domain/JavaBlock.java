package com.benrhine.domain;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/** =================================================================================================================
 * Interchangeable hashing implementation. (Java)
 *
 * This block implementation does hashing using pure java classes
 * ================================================================================================================== */
public class JavaBlock {
    private Integer index = null;
    private String timestamp = null;
    private String data = null;
    private String previousHash = null;
    private String hash = null;

    public JavaBlock() { /* Default Constructor Unused */}

    public JavaBlock(final Integer index, final String timestamp, final String data, final String previousHash) {
        this.index = index;
        this.timestamp = timestamp;
        this.data = data;
        this.previousHash = previousHash;
        this.hash = this.hashBlock();
    }

    private String hashBlock() {
        try {
            final String originalString = this.index.toString() + this.timestamp + this.data + this.previousHash;
            final MessageDigest digest = MessageDigest.getInstance("SHA-256");
            final byte[] encodedHash = digest.digest(originalString.getBytes(StandardCharsets.UTF_8));

            return bytesToHex(encodedHash);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /** Public Getters */
    public Integer getIndex() {
        return this.index;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public String getData() {
        return this.data;
    }

    public String getPreviousHash() {
        return this.previousHash;
    }

    public String getHash() {
        return this.hash;
    }

    /** Private helper functions: =================================================================================== */
    private static String bytesToHex(byte[] hash) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
