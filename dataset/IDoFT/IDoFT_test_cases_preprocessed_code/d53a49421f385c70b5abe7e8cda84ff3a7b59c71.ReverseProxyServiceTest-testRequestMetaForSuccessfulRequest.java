@Test public void testRequestMetaForSuccessfulRequest() throws Exception {
assertThat(onlineServerMetaIndexProvider.get().getBalancer().size(),equalTo(3));
assertEquals("foo",requestMeta.getHeaders().get("X-foo"));
corporaAsserter.assertEquals("testRequestMetaForSuccessfulRequest",content);
}