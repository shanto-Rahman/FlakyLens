@SuppressWarnings("unchecked") @Test public void should_set_partition_components() throws Exception {
assertThat((List<Object>)Whitebox.getInternalState(builder,"partitionComponents")).containsExactly(11L);
}