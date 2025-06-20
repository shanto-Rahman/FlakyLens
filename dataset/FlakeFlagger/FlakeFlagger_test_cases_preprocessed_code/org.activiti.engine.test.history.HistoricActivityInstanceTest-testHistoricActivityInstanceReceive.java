@Deployment public void testHistoricActivityInstanceReceive(){
assertEquals("receive",historicActivityInstance.getActivityId());
assertEquals("receiveTask",historicActivityInstance.getActivityType());
assertNull(historicActivityInstance.getEndTime());
assertNull(historicActivityInstance.getDurationInMillis());
assertNotNull(historicActivityInstance.getProcessDefinitionId());
assertEquals(processInstance.getId(),historicActivityInstance.getProcessInstanceId());
assertNotNull(historicActivityInstance.getStartTime());
assertEquals("receive",historicActivityInstance.getActivityId());
assertEquals("receiveTask",historicActivityInstance.getActivityType());
assertNotNull(historicActivityInstance.getEndTime());
assertTrue(historicActivityInstance.getDurationInMillis() >= 0);
assertNotNull(historicActivityInstance.getProcessDefinitionId());
assertEquals(processInstance.getId(),historicActivityInstance.getProcessInstanceId());
assertNotNull(historicActivityInstance.getStartTime());
}