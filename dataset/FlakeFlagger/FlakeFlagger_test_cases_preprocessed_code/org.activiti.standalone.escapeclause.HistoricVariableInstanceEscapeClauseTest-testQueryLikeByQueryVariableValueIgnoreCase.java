@Test public void testQueryLikeByQueryVariableValueIgnoreCase(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertNotNull(historicVariable);
assertEquals(processInstance1.getId(),historicVariable.getProcessInstanceId());
assertNotNull(historicVariable);
assertEquals(processInstance2.getId(),historicVariable.getProcessInstanceId());
}
}