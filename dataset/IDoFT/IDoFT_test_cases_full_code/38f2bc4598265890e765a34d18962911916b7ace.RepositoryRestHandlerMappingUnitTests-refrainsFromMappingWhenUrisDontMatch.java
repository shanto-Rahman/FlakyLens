@Test public void refrainsFromMappingWhenUrisDontMatch() throws Exception {
  String baseUri="foo";
  String uri=baseUri.concat("/people");
  when(mappings.exportsTopLevelResourceFor("/people")).thenReturn(true);
  mockRequest=new MockHttpServletRequest("GET",uri);
  mockRequest.setServletPath(uri);
  configuration.setBasePath(baseUri);
  HandlerMethod method=handlerMapping.get().getHandlerInternal(mockRequest);
  assertThat(method).isNull();
}
