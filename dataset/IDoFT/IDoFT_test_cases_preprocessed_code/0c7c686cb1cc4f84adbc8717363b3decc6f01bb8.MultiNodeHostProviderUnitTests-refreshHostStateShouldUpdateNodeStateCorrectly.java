@Test public void refreshHostStateShouldUpdateNodeStateCorrectly(){
assertThat(delegateHostProvider.getCachedHostState()).extracting(ElasticsearchHost::getState).containsExactly(State.OFFLINE,State.ONLINE,State.ONLINE);
}