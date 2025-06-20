@Test public void multipleQueryRuns(){
  final int executions=16;
  final int trackEvery=5;
  final int numTraces=executions / trackEvery;
  OrderedPropertyIndexProvider.setThreshold(trackEvery);
  List<String> expectedLogs=Collections.nCopies(numTraces,OrderedIndex.DEPRECATION_MESSAGE);
  custom.starting();
  for (int i=0; i < executions; i++) {
    executeQuery("SELECT * FROM [oak:Unstructured]",SQL2);
  }
  assertThat(custom.getLogs(),is(expectedLogs));
  custom.finished();
}
