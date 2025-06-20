@Test void shouldReportMissingAnnotations(){
  assertThatThrownBy(() -> this.mappingContext.getRequiredPersistentEntity(MissingAnnotation.class)).isInstanceOf(MappingException.class).hasMessageContaining("Missing @Element annotation in mapped tuple type for property [street]");
}
