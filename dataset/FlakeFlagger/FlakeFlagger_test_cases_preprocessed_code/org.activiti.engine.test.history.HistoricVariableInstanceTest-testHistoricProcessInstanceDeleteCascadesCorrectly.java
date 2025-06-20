@Deployment public void testHistoricProcessInstanceDeleteCascadesCorrectly(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.FULL)) {
assertNotNull(processInstance);
assertNotNull(processInstance2);
assertEquals(4,count);
assertEquals(2,count);
}
}