@Test public void testQosAcceptForeignIp() throws Exception {
assertThat(application.getQosAcceptForeignIp(),is(true));
assertThat(parameters,hasEntry(Constants.ACCEPT_FOREIGN_IP,"true"));
}