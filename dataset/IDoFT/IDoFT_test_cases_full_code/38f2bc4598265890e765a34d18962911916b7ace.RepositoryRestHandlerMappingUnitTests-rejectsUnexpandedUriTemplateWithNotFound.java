@Test public void rejectsUnexpandedUriTemplateWithNotFound() throws Exception {
  when(mappings.exportsTopLevelResourceFor("/people")).thenReturn(true);
  mockRequest=new MockHttpServletRequest("GET","/people{?projection}");
  assertThat(handlerMapping.get().getHandler(mockRequest)).isNull();
}
