/** 
 * Test for https://activiti.atlassian.net/browse/ACT-4035.
 */
@Deployment public void testExclusiveJobs(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
if (endTimeB > endTimeA) {
}
assertTrue(endTimeDifference > 6000);
}
}