@Deployment public void testOrQuery(){
assertEquals(1,task.getProcessVariables().size());
assertEquals(123,task.getProcessVariables().get("anotherProcessVar"));
assertNull(task);
assertEquals(1,task.getProcessVariables().size());
assertEquals(123,task.getProcessVariables().get("anotherProcessVar"));
assertEquals(1,task.getProcessVariables().size());
assertEquals(123,task.getProcessVariables().get("anotherProcessVar"));
assertNull(task);
assertEquals(1,task.getProcessVariables().size());
assertEquals(123,task.getProcessVariables().get("anotherProcessVar"));
}