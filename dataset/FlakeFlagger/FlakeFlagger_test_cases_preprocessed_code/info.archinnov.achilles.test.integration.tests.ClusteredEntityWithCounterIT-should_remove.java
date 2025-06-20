@Test public void should_remove() throws Exception {
Thread.sleep(2000);
assertThat(manager.find(ClusteredEntityWithCounter.class,compoundKey)).isNull();
}