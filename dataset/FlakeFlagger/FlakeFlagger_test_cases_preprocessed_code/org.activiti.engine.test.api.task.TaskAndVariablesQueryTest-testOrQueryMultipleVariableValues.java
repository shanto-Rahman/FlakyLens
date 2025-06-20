@Deployment public void testOrQueryMultipleVariableValues(){
assertNull(query0.singleResult());
assertEquals(2,task.getProcessVariables().size());
assertEquals(123,task.getProcessVariables().get("anotherProcessVar"));
}