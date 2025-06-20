@Test public void disableMapperFeature() throws Exception {
assertTrue(MapperFeature.USE_ANNOTATIONS.enabledByDefault());
assertFalse(mapper.getDeserializationConfig().hasMapperFeatures(MapperFeature.USE_ANNOTATIONS.getMask()));
assertFalse(mapper.getSerializationConfig().hasMapperFeatures(MapperFeature.USE_ANNOTATIONS.getMask()));
}