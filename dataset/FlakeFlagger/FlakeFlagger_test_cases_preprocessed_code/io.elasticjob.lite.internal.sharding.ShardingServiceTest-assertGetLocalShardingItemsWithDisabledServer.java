@Test public void assertGetLocalShardingItemsWithDisabledServer(){
assertThat(shardingService.getLocalShardingItems(),is(Collections.<Integer>emptyList()));
}