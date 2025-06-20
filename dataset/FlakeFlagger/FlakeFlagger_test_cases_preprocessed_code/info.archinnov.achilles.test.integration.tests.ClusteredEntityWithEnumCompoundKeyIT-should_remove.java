@Test public void should_remove() throws Exception {
assertThat(manager.find(ClusteredEntityWithEnumCompoundKey.class,compoundKey)).isNull();
}