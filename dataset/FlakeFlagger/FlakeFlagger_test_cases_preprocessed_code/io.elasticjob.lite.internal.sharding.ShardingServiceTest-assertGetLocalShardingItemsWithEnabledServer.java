@Test public void assertGetLocalShardingItemsWithEnabledServer(){
assertThat(shardingService.getLocalShardingItems(),is(Arrays.asList(0,2)));
}