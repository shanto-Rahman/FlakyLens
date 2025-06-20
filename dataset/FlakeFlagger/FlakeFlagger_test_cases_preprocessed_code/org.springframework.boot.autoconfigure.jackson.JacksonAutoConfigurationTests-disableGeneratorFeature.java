@Test public void disableGeneratorFeature() throws Exception {
assertTrue(JsonGenerator.Feature.AUTO_CLOSE_TARGET.enabledByDefault());
assertFalse(mapper.getFactory().isEnabled(JsonGenerator.Feature.AUTO_CLOSE_TARGET));
}