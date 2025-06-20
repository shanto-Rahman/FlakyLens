public void testIncludeVariableUpdates(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.FULL)) {
assertEquals(3,events.size());
assertTrue(event instanceof HistoricVariableUpdate);
}
}