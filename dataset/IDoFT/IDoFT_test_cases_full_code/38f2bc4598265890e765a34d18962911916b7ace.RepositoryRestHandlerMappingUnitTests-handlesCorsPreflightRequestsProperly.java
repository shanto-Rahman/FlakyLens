@Test public void handlesCorsPreflightRequestsProperly() throws Exception {
  when(mappings.exportsTopLevelResourceFor("/people")).thenReturn(true);
  MockHttpServletRequest request=new MockHttpServletRequest("OPTIONS","/people/search");
  request.addHeader(HttpHeaders.ORIGIN,"test case");
  request.addHeader(HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD,"GET");
  assertThatCode(() -> handlerMapping.get().getHandlerInternal(request)).doesNotThrowAnyException();
}
