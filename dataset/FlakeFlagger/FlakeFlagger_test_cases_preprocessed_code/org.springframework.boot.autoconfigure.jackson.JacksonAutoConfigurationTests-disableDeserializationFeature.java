@Test public void disableDeserializationFeature() throws Exception {
assertTrue(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES.enabledByDefault());
assertFalse(mapper.getDeserializationConfig().hasDeserializationFeatures(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES.getMask()));
}