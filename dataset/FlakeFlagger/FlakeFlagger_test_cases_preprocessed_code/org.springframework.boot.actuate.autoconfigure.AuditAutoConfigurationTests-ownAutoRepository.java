@Test public void ownAutoRepository() throws Exception {
assertThat(this.context.getBean(AuditEventRepository.class),instanceOf(TestAuditEventRepository.class));
}