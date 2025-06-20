@Test public void assertNew(){
assertThat(actual.getJobName(),is(shardingContexts.getJobName()));
assertThat(actual.getTaskId(),is(shardingContexts.getTaskId()));
assertThat(actual.getShardingTotalCount(),is(shardingContexts.getShardingTotalCount()));
assertThat(actual.getJobParameter(),is(shardingContexts.getJobParameter()));
assertThat(actual.getShardingItem(),is(1));
assertThat(actual.getShardingParameter(),is(shardingContexts.getShardingItemParameters().get(1)));
}