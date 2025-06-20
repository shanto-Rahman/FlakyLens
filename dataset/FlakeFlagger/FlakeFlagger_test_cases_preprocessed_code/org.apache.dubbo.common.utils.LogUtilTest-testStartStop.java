@Test public void testStartStop() throws Exception {
assertThat(DubboAppender.available,is(true));
assertThat(DubboAppender.available,is(false));
}