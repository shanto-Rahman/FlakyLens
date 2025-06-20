@Test public void assertGetShardingContextWhenIsFailoverEnableAndFailover(){
assertThat(liteJobFacade.getShardingContexts(),is(shardingContexts));
}