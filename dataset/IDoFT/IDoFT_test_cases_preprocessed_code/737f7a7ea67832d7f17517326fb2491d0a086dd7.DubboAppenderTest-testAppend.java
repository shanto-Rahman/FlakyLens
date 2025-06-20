@Test public void testAppend() throws Exception {
assertThat(DubboAppender.logList,hasSize(0));
assertThat(DubboAppender.logList,hasSize(1));
assertThat(log.getLogThread(),equalTo("thread-name"));
}