public void testTaskGetVariables(){
assertEquals(70,vars.size());
if (variableValue instanceof String) {
if (variableValue instanceof Integer) {
if (variableValue instanceof Boolean) {
if (variableValue instanceof Date) {
if (variableValue instanceof LocalDate) {
if (variableValue instanceof DateTime) {
if (variableValue instanceof TestSerializableVariable) {
}
}
}
}
}
}
}
assertEquals(10,nrOfStrings);
assertEquals(10,nrOfBooleans);
assertEquals(10,nrOfDates);
assertEquals(10,nrOfLocalDates);
assertEquals(10,nrOfDateTimes);
assertEquals(10,nrOfInts);
assertEquals(10,nrOfSerializable);
assertEquals(0,taskService.getVariablesLocal(task.getId()).size());
assertEquals(2,taskService.getVariables(task.getId(),Arrays.asList("intVar2","intVar5")).size());
assertEquals(0,taskService.getVariablesLocal(task.getId(),Arrays.asList("intVar2","intVar5")).size());
assertEquals("stringVarValue-3",taskService.getVariable(task.getId(),"stringVar3"));
assertNull(taskService.getVariable(task.getId(),"stringVarDoesNotExist"));
assertNull(taskService.getVariableLocal(task.getId(),"stringVar3"));
assertEquals(71,taskService.getVariables(task.getId()).size());
assertEquals(1,taskService.getVariablesLocal(task.getId()).size());
assertEquals(2,taskService.getVariables(task.getId(),Arrays.asList("intVar2","intVar5")).size());
assertEquals(0,taskService.getVariablesLocal(task.getId(),Arrays.asList("intVar2","intVar5")).size());
assertEquals("localTaskVarValue",taskService.getVariable(task.getId(),"localTaskVar"));
assertEquals("localTaskVarValue",taskService.getVariableLocal(task.getId(),"localTaskVar"));
assertEquals("stringVarValue-1",taskService.getVariable(task.getId(),"stringVar1"));
assertEquals("stringVarValue-1",taskService.getVariable(task.getId(),"stringVar1"));
assertEquals("stringVarValue-1",taskService.getVariables(task.getId(),varNames).get("stringVar1"));
assertEquals(71,taskService.getVariables(task.getId()).size());
assertEquals("Override",taskService.getVariable(task.getId(),"stringVar1"));
assertEquals("Override",taskService.getVariables(task.getId(),varNames).get("stringVar1"));
}