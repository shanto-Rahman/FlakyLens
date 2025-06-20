@Test public void bridgeHandlerLifecycle(){
  assertThat(bridgeHandlerInstalled()).isFalse();
  this.loggingSystem.beforeInitialize();
  assertThat(bridgeHandlerInstalled()).isTrue();
  this.loggingSystem.cleanUp();
  assertThat(bridgeHandlerInstalled()).isFalse();
}
