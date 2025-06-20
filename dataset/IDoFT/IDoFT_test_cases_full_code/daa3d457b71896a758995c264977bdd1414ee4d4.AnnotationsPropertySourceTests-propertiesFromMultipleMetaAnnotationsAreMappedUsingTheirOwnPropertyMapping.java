@Test public void propertiesFromMultipleMetaAnnotationsAreMappedUsingTheirOwnPropertyMapping(){
  AnnotationsPropertySource source=new AnnotationsPropertySource(PropertiesFromMultipleMetaAnnotations.class);
  assertThat(source.getPropertyNames()).containsExactly("value","test.value","test.example");
  assertThat(source.getProperty("value")).isEqualTo("alpha");
  assertThat(source.getProperty("test.value")).isEqualTo("bravo");
  assertThat(source.getProperty("test.example")).isEqualTo("charlie");
}
