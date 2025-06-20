@Test public void testCheckNoError() throws Exception {
assertThat(LogUtil.checkNoError(),is(false));
assertThat(LogUtil.checkNoError(),is(true));
}