@Deployment public void testAsyncEndEvent(){
assertEquals(1,managementService.createJobQuery().count());
assertNull(value);
assertEquals(0,managementService.createJobQuery().count());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
assertEquals(3,variables.size());
if ("variableSetInExecutionListener".equals(variable.getVariableName())) {
}
assertEquals("firstValue",historyValue);
}
}