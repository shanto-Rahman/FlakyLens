public void testOrQueryMultipleVariableValues(){
assertNull(query0.singleResult());
assertNull(query0.singleResult());
assertEquals(1,variableMap.size());
assertEquals(123,variableMap.get("anothertest"));
query2=query2.endOr().or().processDefinitionKey(PROCESS_DEFINITION_KEY_2).processDefinitionId("undefined").endOr();//RW
assertNull(query2.singleResult());
query3=query3.endOr().or().processDefinitionKey(PROCESS_DEFINITION_KEY_2).processDefinitionId("undefined").endOr();//RW
assertEquals(1,variableMap.size());
assertEquals(123,variableMap.get("anothertest"));
}