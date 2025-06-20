@Test public void exposesEffectiveRepositoryLookupPathAsRequestAttribute() throws Exception {
  when(mappings.exportsTopLevelResourceFor("/people")).thenReturn(true);
  MockHttpServletRequest mockRequest=new MockHttpServletRequest("GET","/people/search/findByLastnameLike");
  handlerMapping.get().getHandlerInternal(mockRequest);
  assertThat(mockRequest.getAttribute(RepositoryRestHandlerMapping.EFFECTIVE_LOOKUP_PATH_ATTRIBUTE)).isInstanceOfSatisfying(PathPattern.class,it -> {
    assertThat(it.getPatternString()).isEqualTo("/people/search/{search}");
  }
);
}
