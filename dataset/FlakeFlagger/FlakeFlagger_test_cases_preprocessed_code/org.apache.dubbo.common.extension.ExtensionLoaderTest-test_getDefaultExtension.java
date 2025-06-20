@Test public void test_getDefaultExtension() throws Exception {
assertThat(ext,instanceOf(SimpleExtImpl1.class));
assertEquals("impl1",name);
}