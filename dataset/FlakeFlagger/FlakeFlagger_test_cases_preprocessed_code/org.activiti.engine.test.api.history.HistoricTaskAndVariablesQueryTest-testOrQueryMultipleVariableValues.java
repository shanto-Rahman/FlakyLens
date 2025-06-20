@Deployment public void testOrQueryMultipleVariableValues(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertNull(query0.singleResult());
assertEquals(2,task.getProcessVariables().size());
assertEquals(true,task.getProcessVariables().get("processVar"));
assertEquals(123,task.getProcessVariables().get("anotherProcessVar"));
}
}