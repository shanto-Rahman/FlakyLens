@Deployment public void testGetVariablesLocalByTaskIds(){
if ("usertask1".equals(task.getTaskDefinitionKey())) {
}
if ("usertask1".equals(task.getTaskDefinitionKey())) {
}
assertEquals(2,variables.size());
assertEquals(4,variables.size());
assertEquals(2,variables.size());
}