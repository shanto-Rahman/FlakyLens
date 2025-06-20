@Test public void testFindLevelWithThreadName() throws Exception {
assertThat(LogUtil.findLevelWithThreadName(Level.ERROR,"thread-2"),equalTo(1));
}