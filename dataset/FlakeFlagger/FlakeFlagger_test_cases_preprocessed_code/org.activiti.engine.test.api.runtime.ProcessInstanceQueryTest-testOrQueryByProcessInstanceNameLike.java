public void testOrQueryByProcessInstanceNameLike(){
assertNotNull(runtimeService.createProcessInstanceQuery().or().processInstanceNameLike("% name").processDefinitionId("undefined").endOr().singleResult());
assertEquals(1,runtimeService.createProcessInstanceQuery().or().processInstanceNameLike("new name").processDefinitionId("undefined").endOr().list().size());
assertNull(runtimeService.createProcessInstanceQuery().or().processInstanceNameLike("%nope").processDefinitionId("undefined").endOr().singleResult());
}