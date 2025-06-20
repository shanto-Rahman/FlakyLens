public void testCaseInsensitive() throws Exception {
assertTrue(matcher.matches("TEST"));
assertTrue(matcher.matches("tEst"));
assertTrue(matcher.matches("tESt"));
assertTrue(matcher.matches("TesT"));
}