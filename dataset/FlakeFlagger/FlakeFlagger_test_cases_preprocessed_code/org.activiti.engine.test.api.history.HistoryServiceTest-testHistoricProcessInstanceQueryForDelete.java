@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testHistoricProcessInstanceQueryForDelete(){
assertEquals(1,processInstanceQuery.count());
assertEquals(processInstanceId,processInstance.getId());
assertEquals(DeleteReason.PROCESS_INSTANCE_DELETED,processInstance.getDeleteReason());
assertEquals(1,processInstanceQuery.count());
assertEquals(processInstanceId,processInstance.getId());
assertEquals(DeleteReason.PROCESS_INSTANCE_DELETED,processInstance.getDeleteReason());
assertEquals(0,processInstanceQuery.count());
assertEquals(0,processInstanceQuery.count());
assertEquals(1,processInstanceQuery.count());
assertEquals(processInstanceId,processInstance.getId());
assertEquals("custom message",processInstance.getDeleteReason());
assertEquals(1,processInstanceQuery.count());
assertEquals(processInstanceId,processInstance.getId());
assertEquals("custom message",processInstance.getDeleteReason());
assertEquals(0,processInstanceQuery.count());
}