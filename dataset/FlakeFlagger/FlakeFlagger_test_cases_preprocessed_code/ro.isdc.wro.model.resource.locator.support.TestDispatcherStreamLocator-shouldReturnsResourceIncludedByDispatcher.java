@Test public void shouldReturnsResourceIncludedByDispatcher() throws Exception {
assertEquals(content,IOUtils.toString(victim.getInputStream(mockRequest,mockResponse,"/static/*.js")));
}