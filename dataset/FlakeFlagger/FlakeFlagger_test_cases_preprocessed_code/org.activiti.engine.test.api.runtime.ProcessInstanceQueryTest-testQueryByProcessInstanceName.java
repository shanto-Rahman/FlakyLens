public void testQueryByProcessInstanceName(){
assertNotNull(runtimeService.createProcessInstanceQuery().processInstanceName("new name").singleResult());
assertEquals(1,runtimeService.createProcessInstanceQuery().processInstanceName("new name").list().size());
assertNull(runtimeService.createProcessInstanceQuery().processInstanceName("unexisting").singleResult());
}