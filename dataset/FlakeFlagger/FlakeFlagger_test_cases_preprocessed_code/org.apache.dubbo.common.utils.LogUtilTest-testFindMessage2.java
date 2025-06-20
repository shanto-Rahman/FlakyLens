@Test public void testFindMessage2() throws Exception {
assertThat(LogUtil.findMessage(Level.ERROR,"message"),equalTo(1));
}