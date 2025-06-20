@Test public void loadOnStartAfterContextIsInitialized() throws Exception {
assertThat(servlet.getInitCount(),equalTo(0));
assertThat(servlet.getInitCount(),equalTo(1));
}