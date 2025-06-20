public void testIncludeVariables(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.FULL)) {
assertEquals(1,events.size());
assertTrue(event instanceof HistoricVariableInstance);
assertEquals(((HistoricVariableInstanceEntity)event).getValue(),LARGE_STRING_VALUE);//RW
}
}