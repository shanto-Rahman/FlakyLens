@Test public void looksUpRepositoryEntityControllerMethodCorrectly() throws Exception {
  when(mappings.exportsTopLevelResourceFor("/people")).thenReturn(true);
  mockRequest=new MockHttpServletRequest("GET","/people");
  HandlerMethod method=handlerMapping.get().getHandlerInternal(mockRequest);
  assertThat(method).isNotNull();
  assertThat(method.getMethod()).isEqualTo(listEntitiesMethod);
}
