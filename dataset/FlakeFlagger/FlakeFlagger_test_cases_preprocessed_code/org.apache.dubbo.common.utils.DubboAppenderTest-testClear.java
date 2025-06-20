@Test public void testClear() throws Exception {
assertThat(DubboAppender.logList,hasSize(1));
assertThat(DubboAppender.logList,hasSize(0));
}