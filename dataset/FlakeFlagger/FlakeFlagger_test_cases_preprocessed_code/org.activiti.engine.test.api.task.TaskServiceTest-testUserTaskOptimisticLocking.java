@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testUserTaskOptimisticLocking(){
fail("Expecting exception");
}