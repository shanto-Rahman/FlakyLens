@Test public void refrainsFromMappingIfTheRequestDoesNotPointIntoAbsolutelyDefinedUriSpace() throws Exception {
  mockRequest=new MockHttpServletRequest("GET","/servlet-path");
  mockRequest.setServletPath("/servlet-path");
  configuration.setBasePath("/base");
  HandlerMethod method=handlerMapping.get().getHandlerInternal(mockRequest);
  assertThat(method).isNull();
}
