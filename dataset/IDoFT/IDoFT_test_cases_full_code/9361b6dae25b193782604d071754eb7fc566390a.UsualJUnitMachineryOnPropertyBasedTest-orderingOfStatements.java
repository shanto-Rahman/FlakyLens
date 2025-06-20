@Test public void orderingOfStatements() throws Exception {
  assertThat(testResult(PropertyBasedTests.class),isSuccessful());
  assertEquals(expectedStatements,PropertyBasedTests.LOGS);
}
