@Test public void testCustomParameter(){
assertThat(protocolConfig.getParameters().size(),is(1));
assertThat(protocolConfig.getParameters().get("protocol-paramA"),is("protocol-paramA"));
assertThat(serviceBean.getParameters().size(),is(1));
assertThat(serviceBean.getParameters().get("service-paramA"),is("service-paramA"));
}