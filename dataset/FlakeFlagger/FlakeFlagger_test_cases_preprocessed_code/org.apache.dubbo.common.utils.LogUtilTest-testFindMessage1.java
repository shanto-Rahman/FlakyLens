@Test public void testFindMessage1() throws Exception {
assertThat(LogUtil.findMessage("message"),equalTo(1));
}