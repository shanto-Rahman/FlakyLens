@SuppressWarnings("unchecked") public void testResolveTaskWithParametersEmptyParameters(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
}
assertEquals(DelegationState.RESOLVED,task.getDelegationState());
}