@Test public void singleQueryRun(){
assertEquals(1,logs.size());
assertThat(logs,hasItem(OrderedIndex.DEPRECATION_MESSAGE));
}