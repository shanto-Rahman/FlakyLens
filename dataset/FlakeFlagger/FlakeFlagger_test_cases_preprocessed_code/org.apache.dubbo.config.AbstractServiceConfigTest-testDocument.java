@Test public void testDocument() throws Exception {
assertThat(serviceConfig.getDocument(),equalTo("http://dubbo.io"));
assertThat(parameters,hasEntry("document","http%3A%2F%2Fdubbo.io"));
}