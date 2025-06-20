@Test public void testRegistrationWithDifferentDomainAndIdentity() throws Exception {
assertNotNull(mbeanExporter.getServer().getMBeanInfo(getObjectName("test-domain","endpoint1",true,this.context)));
}