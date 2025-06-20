@Test public void disableParserFeature() throws Exception {
assertTrue(JsonParser.Feature.AUTO_CLOSE_SOURCE.enabledByDefault());
assertFalse(mapper.getFactory().isEnabled(JsonParser.Feature.AUTO_CLOSE_SOURCE));
}