public void testIncludeVariables(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.FULL)) {
assertEquals(2,events.size());
assertTrue(event instanceof HistoricVariableInstance);
}
}