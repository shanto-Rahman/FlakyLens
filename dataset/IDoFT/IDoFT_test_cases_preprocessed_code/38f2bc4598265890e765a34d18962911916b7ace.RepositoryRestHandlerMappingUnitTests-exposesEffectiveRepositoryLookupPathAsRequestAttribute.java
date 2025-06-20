@Test public void exposesEffectiveRepositoryLookupPathAsRequestAttribute() throws Exception {
assertThat(mockRequest.getAttribute(RepositoryRestHandlerMapping.EFFECTIVE_LOOKUP_PATH_ATTRIBUTE)).isInstanceOfSatisfying(PathPattern.class,it -> {
  assertThat(it.getPatternString()).isEqualTo("/people/search/{search}");
}
);
assertThat(it.getPatternString()).isEqualTo("/people/search/{search}");
}