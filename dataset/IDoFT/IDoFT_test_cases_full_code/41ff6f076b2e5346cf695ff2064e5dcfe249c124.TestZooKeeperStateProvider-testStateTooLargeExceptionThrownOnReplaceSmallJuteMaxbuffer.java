@Test(timeout=5000) public void testStateTooLargeExceptionThrownOnReplaceSmallJuteMaxbuffer() throws Exception {
  final Map<String,String> initialState=new HashMap<>();
  final String stateValue=UUID.randomUUID().toString();
  final int maxBufferSize=100;
  initialState.put("1",stateValue);
  final Map<PropertyDescriptor,String> properties=new HashMap<>(defaultProperties);
  properties.put(ZooKeeperStateProvider.CONNECTION_STRING,zkServer.getConnectString());
  final ZooKeeperStateProvider stateProvider=new ZooKeeperStateProvider();
  final Properties applicationProperties=new Properties();
  applicationProperties.setProperty(NiFiProperties.ZOOKEEPER_JUTE_MAXBUFFER,Integer.toString(maxBufferSize));
  final NiFiProperties providerProperties=NiFiProperties.createBasicNiFiProperties(null,applicationProperties);
  stateProvider.setNiFiProperties(providerProperties);
  initializeProvider(stateProvider,properties);
  try {
    stateProvider.enable();
    while (true) {
      try {
        stateProvider.setState(initialState,componentId);
        break;
      }
 catch (      final IOException ioe) {
        Thread.sleep(1000L);
      }
    }
    final Map<String,String> state=new HashMap<>();
    state.put("1",stateValue);
    state.put("2",stateValue);
    state.put("3",stateValue);
    state.put("4",stateValue);
    assertThrows(StateTooLargeException.class,() -> stateProvider.replace(getProvider().getState(componentId),state,componentId));
  }
  finally {
    stateProvider.shutdown();
  }
}
