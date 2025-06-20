@Test public void testAvailable() throws Exception {
assertThat(DubboAppender.available,is(false));
assertThat(DubboAppender.available,is(true));
assertThat(DubboAppender.available,is(false));
}