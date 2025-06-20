@Test public void initShouldNotCauseEarlyInitialization() throws Exception {
assertThat(mockFilterInitialized.get()).isNull();//RW
assertThat(mockFilterInitialized.get()).isTrue();//RW
}