@Test public void testAccesslog() throws Exception {
assertThat(serviceConfig.getAccesslog(),equalTo("access.log"));
assertThat(serviceConfig.getAccesslog(),nullValue());
assertThat(serviceConfig.getAccesslog(),equalTo("true"));
}