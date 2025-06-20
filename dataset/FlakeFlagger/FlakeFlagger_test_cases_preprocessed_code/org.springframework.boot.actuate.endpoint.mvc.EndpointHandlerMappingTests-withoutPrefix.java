@Test public void withoutPrefix() throws Exception {
assertThat(mapping.getHandler(new MockHttpServletRequest("GET","/a")).getHandler(),equalTo((Object)new HandlerMethod(endpointA,this.method)));
assertThat(mapping.getHandler(new MockHttpServletRequest("GET","/b")).getHandler(),equalTo((Object)new HandlerMethod(endpointB,this.method)));
assertThat(mapping.getHandler(new MockHttpServletRequest("GET","/c")),nullValue());
}