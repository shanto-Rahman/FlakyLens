@Test public void assertGetCurrentShardingTotalCountIfNotNull(){
assertThat(JobRegistry.getInstance().getCurrentShardingTotalCount("exist_job_instance"),is(10));
}