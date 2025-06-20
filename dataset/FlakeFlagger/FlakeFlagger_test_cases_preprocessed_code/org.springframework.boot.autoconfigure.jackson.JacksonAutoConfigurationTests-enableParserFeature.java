@Test public void enableParserFeature() throws Exception {
assertFalse(JsonParser.Feature.ALLOW_SINGLE_QUOTES.enabledByDefault());
assertTrue(mapper.getFactory().isEnabled(JsonParser.Feature.ALLOW_SINGLE_QUOTES));
}