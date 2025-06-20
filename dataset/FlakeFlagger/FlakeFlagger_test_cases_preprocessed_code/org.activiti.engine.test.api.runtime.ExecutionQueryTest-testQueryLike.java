@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testQueryLike(){
assertNotNull(execution);
assertEquals(processInstance1.getId(),execution.getId());
assertNotNull(execution);
assertEquals(processInstance1.getId(),execution.getId());
fail("Exception expected");
assertEquals("Only string values can be used with 'like' condition",ae.getMessage());
fail("Exception expected");
assertEquals("name is null",ae.getMessage());
}