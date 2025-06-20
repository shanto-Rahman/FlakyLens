@Test public void testFindThread() throws Exception {
assertThat(LogUtil.findThread("thread-1"),equalTo(1));
}