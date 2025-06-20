@Test public void should_init_default_object_factory_mapper() throws Exception {
assertThat(actual).isNotNull();
assertThat(mapper).isNotNull();
assertThat(mapper.getSerializationConfig().getSerializationInclusion()).isEqualTo(JsonInclude.Include.NON_NULL);
assertThat(mapper.getDeserializationConfig().isEnabled(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)).isFalse();
assertThat(ais).hasSize(2);
assertThat(iterator.next()).isInstanceOfAny(JacksonAnnotationIntrospector.class,JaxbAnnotationIntrospector.class);
assertThat(iterator.next()).isInstanceOfAny(JacksonAnnotationIntrospector.class,JaxbAnnotationIntrospector.class);
}