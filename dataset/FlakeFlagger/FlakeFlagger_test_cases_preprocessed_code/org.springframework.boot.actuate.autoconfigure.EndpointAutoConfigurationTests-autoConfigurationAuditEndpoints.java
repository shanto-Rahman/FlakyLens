@Test public void autoConfigurationAuditEndpoints(){
assertNotNull(this.context.getBean(AutoConfigurationReportEndpoint.class));
}