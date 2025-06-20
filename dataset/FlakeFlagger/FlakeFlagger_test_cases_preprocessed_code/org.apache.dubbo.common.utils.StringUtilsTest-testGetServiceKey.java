@Test public void testGetServiceKey() throws Exception {
assertThat(StringUtils.getServiceKey(map),equalTo("dubbo/a.b.c.Foo:1.0.0"));
}