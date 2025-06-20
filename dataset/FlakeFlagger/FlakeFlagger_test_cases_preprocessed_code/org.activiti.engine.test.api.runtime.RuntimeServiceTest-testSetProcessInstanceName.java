@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testSetProcessInstanceName(){
assertNotNull(processInstance);
assertNull(processInstance.getName());
assertNotNull(processInstance);
assertEquals("New name",processInstance.getName());
assertNotNull(processInstance);
assertNull(processInstance.getName());
fail("Exception expected");
assertEquals(ProcessInstance.class,aonfe.getObjectClass());
assertNotNull(processInstance);
assertNull(processInstance.getName());
fail("Exception expected");
assertEquals("process instance " + processInstance.getId() + " is suspended, cannot set name",ae.getMessage());
assertNotNull(processInstance);
assertNull(processInstance.getName());
}