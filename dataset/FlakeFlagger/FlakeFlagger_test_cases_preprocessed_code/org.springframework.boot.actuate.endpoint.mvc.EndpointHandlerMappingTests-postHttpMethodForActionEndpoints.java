@Test public void postHttpMethodForActionEndpoints() throws Exception {
assertNotNull(mapping.getHandler(new MockHttpServletRequest("POST","/a")));
}