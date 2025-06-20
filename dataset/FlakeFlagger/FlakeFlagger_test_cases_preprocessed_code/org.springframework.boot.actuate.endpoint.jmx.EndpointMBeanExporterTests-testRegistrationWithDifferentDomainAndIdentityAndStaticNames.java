@Test public void testRegistrationWithDifferentDomainAndIdentityAndStaticNames() throws Exception {
assertNotNull(mbeanExporter.getServer().getMBeanInfo(ObjectNameManager.getInstance(getObjectName("test-domain","endpoint1",true,this.context).toString() + ",key1=value1,key2=value2")));
}