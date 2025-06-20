@Deployment public void testSimpleProcess(){
assertEquals("My Task",task.getName());
assertEquals(0,runtimeService.createProcessInstanceQuery().count());
}