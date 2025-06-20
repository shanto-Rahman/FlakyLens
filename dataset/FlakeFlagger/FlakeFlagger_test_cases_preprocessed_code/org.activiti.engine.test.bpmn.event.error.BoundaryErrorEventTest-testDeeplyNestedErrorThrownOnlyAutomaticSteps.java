@Deployment public void testDeeplyNestedErrorThrownOnlyAutomaticSteps(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals("processEnd1",hip.getEndActivityId());
}
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals("processEnd1",hip.getEndActivityId());
}
}