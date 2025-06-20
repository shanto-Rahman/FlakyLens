@Deployment(resources={"org/activiti/spring/test/email/EmailTaskUsingJndi.bpmn20.xml"}) public void testEmailUsingJndi(){
assertEquals(0,runtimeService.createProcessInstanceQuery().processInstanceId(processInstance.getId()).count());
}