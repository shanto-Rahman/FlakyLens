@Test public void testRequestMetaForSuccessfulRequest() throws Exception {
assertThat(onlineServerMetaIndexProvider.get().getBalancer().size(),equalTo(3));
assertEquals("foo",requestMeta.getHeaders().get("X-foo"));
JSONAssert.assertEquals(content,corporaAsserter.getCorporaCache().read("testRequestMetaForSuccessfulRequest"),false);
}