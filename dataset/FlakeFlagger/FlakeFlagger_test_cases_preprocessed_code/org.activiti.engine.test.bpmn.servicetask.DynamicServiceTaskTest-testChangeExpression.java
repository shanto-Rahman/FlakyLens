@Deployment public void testChangeExpression(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertNotNull(historicVariableInstance);
assertTrue((Boolean)historicVariableInstance.getValue());
}
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertNotNull(historicVariableInstance);
assertTrue((Boolean)historicVariableInstance.getValue());
}
}