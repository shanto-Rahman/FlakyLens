@Test public void testEnsureTlsDisabledAlgorithms(){
  Security.setProperty("jdk.tls.disabledAlgorithms","");
  SecurityUtils.ensureTlsDisabledAlgorithms();
  String disabledAlgorithms=Security.getProperty("jdk.tls.disabledAlgorithms");
  assertNotNull(disabledAlgorithms);
  assertTrue(disabledAlgorithms.contains("TLSv1,"));
  Security.setProperty("jdk.tls.disabledAlgorithms","");
  System.setProperty("com.vmware.admiral.enable.tlsv1",Boolean.TRUE.toString());
  SecurityUtils.ensureTlsDisabledAlgorithms();
  disabledAlgorithms=Security.getProperty("jdk.tls.disabledAlgorithms");
  assertNotNull(disabledAlgorithms);
  assertFalse(disabledAlgorithms.contains("TLSv1,"));
}
