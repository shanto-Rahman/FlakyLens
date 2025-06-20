@Test public void testQueryByTenantIdLike(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertNotNull(historicProcessInstance);
assertEquals(processInstance1.getId(),historicProcessInstance.getId());
assertNotNull(historicProcessInstance);
assertEquals(processInstance2.getId(),historicProcessInstance.getId());
assertNotNull(historicProcessInstance);
assertEquals(processInstance1.getId(),historicProcessInstance.getId());
assertNotNull(historicProcessInstance);
assertEquals(processInstance2.getId(),historicProcessInstance.getId());
}
}