@Test public void propertiesFromMultipleMetaAnnotationsAreMappedUsingTheirOwnPropertyMapping(){
assertThat(source.getPropertyNames()).containsExactly("value","test.value","test.example");
assertThat(source.getProperty("value")).isEqualTo("alpha");
assertThat(source.getProperty("test.value")).isEqualTo("bravo");
assertThat(source.getProperty("test.example")).isEqualTo("charlie");
}