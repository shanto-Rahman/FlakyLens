@Test public void testUGILogin() throws Throwable {
  UserGroupInformation ugi=loginUGI(ZOOKEEPER,keytab_zk);
  RegistrySecurity.UgiInfo ugiInfo=new RegistrySecurity.UgiInfo(ugi);
  LOG.info("logged in as: {}",ugiInfo);
  assertTrue("security is not enabled: " + ugiInfo,UserGroupInformation.isSecurityEnabled());
  assertTrue("login is keytab based: " + ugiInfo,ugi.isFromKeytab());
  ACL acl=ugi.doAs(new PrivilegedExceptionAction<ACL>(){
    @Override public ACL run() throws Exception {
      return registrySecurity.createSaslACLFromCurrentUser(0);
    }
  }
);
  assertEquals(ZOOKEEPER_REALM,acl.getId().getId());
  assertEquals(ZookeeperConfigOptions.SCHEME_SASL,acl.getId().getScheme());
  registrySecurity.addSystemACL(acl);
}
