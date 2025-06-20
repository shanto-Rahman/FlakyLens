@Test public void enableDeserializationFeature() throws Exception {
assertFalse(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS.enabledByDefault());
assertTrue(mapper.getDeserializationConfig().hasDeserializationFeatures(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS.getMask()));
}