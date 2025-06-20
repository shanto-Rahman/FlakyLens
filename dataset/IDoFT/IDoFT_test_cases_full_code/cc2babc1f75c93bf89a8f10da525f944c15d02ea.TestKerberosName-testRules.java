@Test public void testRules() throws Exception {
  checkTranslation("omalley@" + KerberosTestUtils.getRealm(),"omalley");
  checkTranslation("hdfs/10.0.0.1@" + KerberosTestUtils.getRealm(),"hdfs");
  checkTranslation("oom@YAHOO.COM","oom");
  checkTranslation("johndoe/zoo@FOO.COM","guest");
  checkTranslation("joe/admin@FOO.COM","joe");
  checkTranslation("joe/root@FOO.COM","root");
}
