@Test void shouldCreateIsInSet(){
assertThat(serializeToCqlSafely(criteria)).isEqualTo("foo IN {'a','b','c'}");
}