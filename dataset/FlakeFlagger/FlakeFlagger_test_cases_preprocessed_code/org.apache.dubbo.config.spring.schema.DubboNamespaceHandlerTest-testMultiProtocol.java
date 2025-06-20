@Test public void testMultiProtocol(){
assertThat(protocolConfigMap.size(),is(2));
assertThat(rmiProtocolConfig.getPort(),is(10991));
assertThat(dubboProtocolConfig.getPort(),is(20881));
}