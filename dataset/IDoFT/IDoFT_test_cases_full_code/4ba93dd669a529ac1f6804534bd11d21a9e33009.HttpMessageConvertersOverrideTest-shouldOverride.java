@Test void shouldOverride(){
  assertThat(unit.getConverters(),contains(instanceOf(Jaxb2RootElementHttpMessageConverter.class)));
}
