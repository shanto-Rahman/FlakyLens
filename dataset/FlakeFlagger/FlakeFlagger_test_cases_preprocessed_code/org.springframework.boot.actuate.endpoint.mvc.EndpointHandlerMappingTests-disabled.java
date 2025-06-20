@Test public void disabled() throws Exception {
assertThat(mapping.getHandler(new MockHttpServletRequest("GET","/a")),nullValue());
}