@Test public void bridgeHandlerLifecycle(){
assertThat(bridgeHandlerInstalled()).isFalse();
assertThat(bridgeHandlerInstalled()).isTrue();
assertThat(bridgeHandlerInstalled()).isFalse();
}