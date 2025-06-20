public void testHistoricVariableOkOnUpdate(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
assertEquals(1,hisVarList.size());
assertEquals(40,hisVarList.get(0).getValue());
}
}