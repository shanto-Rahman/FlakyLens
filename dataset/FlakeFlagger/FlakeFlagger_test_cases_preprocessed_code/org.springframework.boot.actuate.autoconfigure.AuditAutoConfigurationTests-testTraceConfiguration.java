@Test public void testTraceConfiguration() throws Exception {
assertNotNull(this.context.getBean(AuditEventRepository.class));
assertNotNull(this.context.getBean(AuthenticationAuditListener.class));
assertNotNull(this.context.getBean(AuthorizationAuditListener.class));
}