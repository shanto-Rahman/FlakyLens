@Test public void testQueryByVariableNameLike(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertNotNull(historicVariable);
assertEquals(processInstance1.getId(),historicVariable.getProcessInstanceId());
assertEquals("One%",historicVariable.getValue());
assertNotNull(historicVariable);
assertEquals(processInstance2.getId(),historicVariable.getProcessInstanceId());
assertEquals("Two_",historicVariable.getValue());
}
}