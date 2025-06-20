@Test public void testUGILogin() throws Throwable {
assertTrue("security is not enabled: " + ugiInfo,UserGroupInformation.isSecurityEnabled());
assertTrue("login is keytab based: " + ugiInfo,ugi.isFromKeytab());
assertEquals(ZOOKEEPER_REALM,acl.getId().getId());
assertEquals(ZookeeperConfigOptions.SCHEME_SASL,acl.getId().getScheme());
}