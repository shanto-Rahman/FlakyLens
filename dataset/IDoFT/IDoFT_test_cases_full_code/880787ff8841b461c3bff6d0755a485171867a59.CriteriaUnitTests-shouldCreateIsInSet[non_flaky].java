@Test void shouldCreateIsInSet(){
  CriteriaDefinition criteria=Criteria.where("foo").in(new LinkedHashSet<>(Arrays.asList("a","b","c")));
  assertThat(serializeToCqlSafely(criteria)).isEqualTo("foo IN {'a','b','c'}");
}
