public void testTaskLocalAndProcessInstanceVariableEqualsInOr(){
assertEquals(10,allTasks.size());
assertEquals(2,taskService.createTaskQuery().taskVariableValueEquals("localVar","someValue").list().size());
assertEquals(3,taskService.createTaskQuery().processVariableValueEquals("var","theValue").list().size());
assertEquals(5,taskService.createTaskQuery().or().taskVariableValueEquals("localVar","someValue").processVariableValueEquals("var","theValue").endOr().list().size());
assertEquals(5,taskService.createTaskQuery().or().taskVariableValueEquals("localVar","someValue").processVariableValueEquals("var","theValue").endOr().or().processDefinitionKey("oneTaskProcess").processDefinitionId("notexisting").endOr().list().size());
}