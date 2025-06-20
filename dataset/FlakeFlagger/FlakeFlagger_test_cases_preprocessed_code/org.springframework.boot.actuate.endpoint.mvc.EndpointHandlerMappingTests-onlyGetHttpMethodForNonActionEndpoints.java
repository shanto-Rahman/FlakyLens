@Test(expected=HttpRequestMethodNotSupportedException.class) public void onlyGetHttpMethodForNonActionEndpoints() throws Exception {
assertNotNull(mapping.getHandler(new MockHttpServletRequest("GET","/a")));
assertNull(mapping.getHandler(new MockHttpServletRequest("POST","/a")));
}