@Test public void testGetEmptyUrl() throws Exception {
assertThat(url.toFullString(),equalTo("empty://0.0.0.0/a.b.c.Foo?category=test&group=dubbo&version=1.0.0"));
}