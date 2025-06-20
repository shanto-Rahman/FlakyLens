@Test public void stripsBaseUriForCorsConfigurationResolution(){
  String baseUri="/foo";
  String uri=baseUri.concat("/people");
  configuration.setBasePath(baseUri);
  when(mappings.exportsTopLevelResourceFor("/people")).thenReturn(true);
  when(mappings.iterator()).thenReturn(Collections.singleton(resourceMetadata).iterator());
  when(resourceMetadata.getPath()).thenReturn(new Path("/people"));
  mockRequest=new MockHttpServletRequest("GET",uri);
  mockRequest.setServletPath(uri);
  handlerMapping.get().getCorsConfiguration(uri,mockRequest);
  verify(mappings).exportsTopLevelResourceFor("/people");
}
