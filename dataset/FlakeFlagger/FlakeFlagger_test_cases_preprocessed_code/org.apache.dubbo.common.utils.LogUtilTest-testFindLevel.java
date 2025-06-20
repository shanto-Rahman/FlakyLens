@Test public void testFindLevel() throws Exception {
assertThat(LogUtil.findLevel(Level.ERROR),equalTo(1));
assertThat(LogUtil.findLevel(Level.INFO),equalTo(0));
}