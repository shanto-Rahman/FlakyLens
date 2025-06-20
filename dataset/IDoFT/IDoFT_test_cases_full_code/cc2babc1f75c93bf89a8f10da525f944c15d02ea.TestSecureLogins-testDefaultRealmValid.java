@Test public void testDefaultRealmValid() throws Throwable {
  String defaultRealm=KerberosUtil.getDefaultRealm();
  assertNotEmpty("No default Kerberos Realm",defaultRealm);
  LOG.info("Default Realm '{}'",defaultRealm);
}
