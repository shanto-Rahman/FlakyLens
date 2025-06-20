@Test public void singleQueryRun(){
  custom.starting();
  executeQuery("SELECT * FROM [oak:Unstructured]",SQL2);
  List<String> logs=custom.getLogs();
  assertEquals(1,logs.size());
  assertThat(logs,hasItem(OrderedIndex.DEPRECATION_MESSAGE));
  custom.finished();
}
