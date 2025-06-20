public void testOrQueryMultipleVariableValues(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertNull(query0.singleResult());
assertEquals(1,variableMap.size());
assertEquals(123,variableMap.get("anothertest"));
query2=query2.processDefinitionId("undefined").endOr().or().processDefinitionKey(PROCESS_DEFINITION_KEY_2).processDefinitionId("undefined").endOr();//RW
assertNull(query2.singleResult());
query3=query3.processDefinitionId("undefined").endOr().or().processDefinitionKey(PROCESS_DEFINITION_KEY_2).processDefinitionId("undefined").endOr();//RW
assertEquals(1,variableMap.size());
assertEquals(123,variableMap.get("anothertest"));
}
}