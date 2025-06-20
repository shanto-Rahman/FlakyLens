@Test public void should_remove() throws Exception {
assertThat(manager.find(ClusteredEntityWithObjectValue.class,compoundKey)).isNull();
}