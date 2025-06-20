@Test public void assertLoadDirectly(){
assertThat(actual.getJobName(),is("test_job"));
assertThat(actual.getTypeConfig().getCoreConfig().getCron(),is("0/1 * * * * ?"));
assertThat(actual.getTypeConfig().getCoreConfig().getShardingTotalCount(),is(3));
}