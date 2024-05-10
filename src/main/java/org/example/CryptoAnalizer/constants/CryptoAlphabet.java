package org.example.CryptoAnalizer.constants;

public class CryptoAlphabet {
    private static final String UPPERCASE = "ЙФЯЦЫЧУВСКАМЕПИНРТГОЬШЛБЩДЮЗЖХЭЪ";
    private static final String PUNCTUATION = ",.-;:!?«»() ";
    private static final String DIGITS = "0123456789";
    public static final String ALPHABET = UPPERCASE + UPPERCASE.toLowerCase() + PUNCTUATION + DIGITS;
}
