@Test public void assertGetShardingContextWhenIsFailoverEnableAndNotFailover(){
assertThat(liteJobFacade.getShardingContexts(),is(shardingContexts));
}