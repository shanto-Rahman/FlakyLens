@Test @CmmnDeployment public void testVariableEquals(){
  CaseInstance caseInstance=cmmnRuntimeService.createCaseInstanceBuilder().caseDefinitionKey("testElFunction").start();
  Task task=cmmnTaskService.createTaskQuery().caseInstanceId(caseInstance.getId()).singleResult();
  assertEquals("The Task",task.getName());
  cmmnRuntimeService.setVariable(caseInstance.getId(),"myVar",123);
  List<Task> tasks=cmmnTaskService.createTaskQuery().caseInstanceId(caseInstance.getId()).orderByTaskName().asc().list();
  assertEquals(2,tasks.size());
  assertEquals("Guarded Task",tasks.get(0).getName());
  assertEquals("The Task",tasks.get(1).getName());
}
