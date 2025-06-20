@Test public void testProviderXml(){
assertThat(protocolConfig,not(nullValue()));
assertThat(protocolConfig.getName(),is("dubbo"));
assertThat(protocolConfig.getPort(),is(20813));
assertThat(applicationConfig,not(nullValue()));
assertThat(applicationConfig.getName(),is("demo-provider"));
assertThat(service,not(nullValue()));
}