@Test public void should_refresh() throws Exception {
Thread.sleep(100);
assertThat(entity.getCounter().get()).isEqualTo(counterValue + incr);
assertThat(entity.getVersion().get()).isEqualTo(incr);
}