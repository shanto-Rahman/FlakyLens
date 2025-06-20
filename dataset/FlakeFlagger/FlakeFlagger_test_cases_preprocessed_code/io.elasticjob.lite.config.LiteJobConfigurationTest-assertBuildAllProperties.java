@Test public void assertBuildAllProperties(){
assertFalse(actual.isMonitorExecution());
assertThat(actual.getMaxTimeDiffSeconds(),is(1000));
assertThat(actual.getMonitorPort(),is(8888));
assertThat(actual.getJobShardingStrategyClass(),is("testClass"));
assertTrue(actual.isDisabled());
assertTrue(actual.isOverwrite());
assertThat(actual.getReconcileIntervalMinutes(),is(60));
}