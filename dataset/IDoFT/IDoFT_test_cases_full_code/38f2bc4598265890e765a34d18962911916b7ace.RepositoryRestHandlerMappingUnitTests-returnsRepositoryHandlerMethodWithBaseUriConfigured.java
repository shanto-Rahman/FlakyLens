@Test public void returnsRepositoryHandlerMethodWithBaseUriConfigured() throws Exception {
  when(mappings.exportsTopLevelResourceFor("/people")).thenReturn(true);
  mockRequest=new MockHttpServletRequest("GET","/base/people");
  configuration.setBasePath("/base");
  HandlerMethod method=handlerMapping.get().getHandlerInternal(mockRequest);
  assertThat(method).isNotNull();
  assertThat(method.getMethod()).isEqualTo(listEntitiesMethod);
}
