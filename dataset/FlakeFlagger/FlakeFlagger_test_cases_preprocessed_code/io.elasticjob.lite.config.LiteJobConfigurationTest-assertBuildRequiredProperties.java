@Test public void assertBuildRequiredProperties(){
assertTrue(actual.isMonitorExecution());
assertThat(actual.getMaxTimeDiffSeconds(),is(-1));
assertThat(actual.getMonitorPort(),is(-1));
assertThat(actual.getJobShardingStrategyClass(),is(""));
assertFalse(actual.isDisabled());
assertFalse(actual.isOverwrite());
}