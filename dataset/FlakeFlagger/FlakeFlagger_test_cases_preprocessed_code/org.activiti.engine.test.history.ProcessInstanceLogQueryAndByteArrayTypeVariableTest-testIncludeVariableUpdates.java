public void testIncludeVariableUpdates(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.FULL)) {
assertEquals(historicVariableInstance.getValue(),LARGE_STRING_VALUE);//RW
assertEquals(1,events.size());
assertTrue(event instanceof HistoricVariableUpdate);
assertEquals(((HistoricDetailVariableInstanceUpdateEntity)event).getValue(),LARGE_STRING_VALUE);//RW
}
}