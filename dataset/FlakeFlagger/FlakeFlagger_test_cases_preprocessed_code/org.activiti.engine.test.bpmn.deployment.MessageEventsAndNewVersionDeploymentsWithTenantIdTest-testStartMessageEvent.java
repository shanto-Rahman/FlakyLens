public void testStartMessageEvent(){
assertEquals(1,getAllEventSubscriptions().size());
assertEquals(0,runtimeService.createProcessInstanceQuery().count());
assertEquals(1,runtimeService.createProcessInstanceQuery().count());
assertEquals(2,runtimeService.createProcessInstanceQuery().count());
}