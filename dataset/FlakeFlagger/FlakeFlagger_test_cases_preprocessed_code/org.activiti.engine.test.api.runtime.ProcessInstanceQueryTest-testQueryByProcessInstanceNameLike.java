public void testQueryByProcessInstanceNameLike(){
assertNotNull(runtimeService.createProcessInstanceQuery().processInstanceNameLike("% name").singleResult());
assertEquals(1,runtimeService.createProcessInstanceQuery().processInstanceNameLike("new name").list().size());
assertNull(runtimeService.createProcessInstanceQuery().processInstanceNameLike("%nope").singleResult());
}