@Test public void enableSerializationFeature() throws Exception {
assertFalse(SerializationFeature.INDENT_OUTPUT.enabledByDefault());
assertTrue(mapper.getSerializationConfig().hasSerializationFeatures(SerializationFeature.INDENT_OUTPUT.getMask()));
}