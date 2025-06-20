@Test(expected=HttpRequestMethodNotSupportedException.class) public void onlyPostHttpMethodForActionEndpoints() throws Exception {
assertNotNull(mapping.getHandler(new MockHttpServletRequest("POST","/a")));
assertNull(mapping.getHandler(new MockHttpServletRequest("GET","/a")));
}