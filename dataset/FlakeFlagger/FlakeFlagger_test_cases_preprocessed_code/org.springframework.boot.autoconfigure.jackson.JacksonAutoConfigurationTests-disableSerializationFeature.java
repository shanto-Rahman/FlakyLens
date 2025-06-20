@Test public void disableSerializationFeature() throws Exception {
assertTrue(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS.enabledByDefault());
assertFalse(mapper.getSerializationConfig().hasSerializationFeatures(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS.getMask()));
}