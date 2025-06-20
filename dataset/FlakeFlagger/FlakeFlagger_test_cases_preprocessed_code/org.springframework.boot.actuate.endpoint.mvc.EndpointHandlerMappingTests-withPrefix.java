@Test public void withPrefix() throws Exception {
assertThat(mapping.getHandler(new MockHttpServletRequest("GET","/a/a")).getHandler(),equalTo((Object)new HandlerMethod(endpointA,this.method)));
assertThat(mapping.getHandler(new MockHttpServletRequest("GET","/a/b")).getHandler(),equalTo((Object)new HandlerMethod(endpointB,this.method)));
assertThat(mapping.getHandler(new MockHttpServletRequest("GET","/a")),nullValue());
}