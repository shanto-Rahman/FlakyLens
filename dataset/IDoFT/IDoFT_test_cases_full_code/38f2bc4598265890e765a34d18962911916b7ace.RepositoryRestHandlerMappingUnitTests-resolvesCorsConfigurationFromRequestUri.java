@Test public void resolvesCorsConfigurationFromRequestUri(){
  String uri="/people";
  when(mappings.exportsTopLevelResourceFor("/people")).thenReturn(true);
  when(mappings.iterator()).thenReturn(Collections.singleton(resourceMetadata).iterator());
  when(resourceMetadata.getPath()).thenReturn(new Path("/people"));
  mockRequest=new MockHttpServletRequest("GET",uri);
  mockRequest.setServletPath(uri);
  handlerMapping.get().getCorsConfiguration(uri,mockRequest);
  verify(mappings).exportsTopLevelResourceFor("/people");
}
