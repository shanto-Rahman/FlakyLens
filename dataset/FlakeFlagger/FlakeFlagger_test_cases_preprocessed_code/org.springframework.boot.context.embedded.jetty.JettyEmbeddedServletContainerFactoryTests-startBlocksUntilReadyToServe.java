@Test public void startBlocksUntilReadyToServe() throws Exception {
Thread.sleep(500);
assertThat(date[0],notNullValue());
}