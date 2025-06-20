@Test public void testListener() throws Exception {
assertThat(referenceConfig.getListener(),equalTo("mockinvokerlistener"));
assertThat(parameters,hasValue("prelistener,mockinvokerlistener"));
}