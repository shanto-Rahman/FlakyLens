@Test public void returnsRootHandlerMethodWithBaseUriConfigured() throws Exception {
  mockRequest=new MockHttpServletRequest("GET","/base");
  configuration.setBasePath("/base");
  HandlerMethod method=handlerMapping.get().getHandlerInternal(mockRequest);
  assertThat(method).isNotNull();
  assertThat(method.getMethod()).isEqualTo(rootHandlerMethod);
}
