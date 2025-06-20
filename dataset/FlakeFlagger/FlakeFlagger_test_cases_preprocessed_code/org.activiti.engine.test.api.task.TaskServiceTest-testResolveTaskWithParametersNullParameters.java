public void testResolveTaskWithParametersNullParameters(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
}
assertEquals(DelegationState.RESOLVED,task.getDelegationState());
}