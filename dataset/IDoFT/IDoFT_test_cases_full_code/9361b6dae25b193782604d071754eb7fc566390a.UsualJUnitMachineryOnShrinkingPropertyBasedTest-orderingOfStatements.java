@Test public void orderingOfStatements() throws Exception {
  assertThat(testResult(PropertyBasedTests.class),failureCountIs(1));
  assertEquals(expectedStatements,PropertyBasedTests.LOGS);
}
