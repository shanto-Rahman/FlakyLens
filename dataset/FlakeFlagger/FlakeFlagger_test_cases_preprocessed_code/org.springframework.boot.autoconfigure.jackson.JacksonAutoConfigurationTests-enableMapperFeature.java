@Test public void enableMapperFeature() throws Exception {
assertFalse(MapperFeature.REQUIRE_SETTERS_FOR_GETTERS.enabledByDefault());
assertTrue(mapper.getSerializationConfig().hasMapperFeatures(MapperFeature.REQUIRE_SETTERS_FOR_GETTERS.getMask()));
assertTrue(mapper.getDeserializationConfig().hasMapperFeatures(MapperFeature.REQUIRE_SETTERS_FOR_GETTERS.getMask()));
}