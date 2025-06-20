@Test public void orderingOfStatements(){
assertThat(testResult(PropertyBasedTests.class),isSuccessful());
assertEquals(expectedStatements,PropertyBasedTests.LOGS);
PropertyBasedTests.clearLogs();//IT
}