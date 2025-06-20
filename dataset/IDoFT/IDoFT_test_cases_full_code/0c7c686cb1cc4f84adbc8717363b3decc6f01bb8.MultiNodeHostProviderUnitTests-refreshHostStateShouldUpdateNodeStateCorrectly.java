@Test public void refreshHostStateShouldUpdateNodeStateCorrectly(){
  multiNodeDelegatingHostProvider.when(HOST_1).receive(Receive::error);
  multiNodeDelegatingHostProvider.when(HOST_2).receive(Receive::ok);
  multiNodeDelegatingHostProvider.when(HOST_3).receive(Receive::ok);
  delegateHostProvider.clusterInfo().as(StepVerifier::create).expectNextCount(1).verifyComplete();
  assertThat(delegateHostProvider.getCachedHostState()).extracting(ElasticsearchHost::getState).containsExactly(State.OFFLINE,State.ONLINE,State.ONLINE);
}
