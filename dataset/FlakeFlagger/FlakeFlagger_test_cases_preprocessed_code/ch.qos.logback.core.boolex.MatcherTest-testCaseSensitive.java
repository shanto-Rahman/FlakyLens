public void testCaseSensitive() throws Exception {
assertFalse(matcher.matches("TEST"));
assertFalse(matcher.matches("tEst"));
assertFalse(matcher.matches("tESt"));
assertFalse(matcher.matches("TesT"));
}