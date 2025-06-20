@Deployment(resources={"org/activiti/engine/test/api/runtime/oneTaskProcess.bpmn20.xml"}) public void testUserMultipleTimesinvolvedWithProcessInstance(){
assertEquals(1L,runtimeService.createProcessInstanceQuery().involvedUser("kermit").count());
}