@Test public void testListener() throws Exception {
assertThat(serviceConfig.getListener(),equalTo("mockexporterlistener"));
assertThat(parameters,hasEntry(Constants.EXPORTER_LISTENER_KEY,"prelistener,mockexporterlistener"));
}