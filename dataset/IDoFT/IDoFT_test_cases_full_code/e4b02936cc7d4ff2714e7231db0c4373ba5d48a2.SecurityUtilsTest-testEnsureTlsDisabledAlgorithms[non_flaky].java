@Test public void testEnsureTlsDisabledAlgorithms(){
  Security.setProperty("jdk.tls.disabledAlgorithms","");
  SecurityUtils.ensureTlsDisabledAlgorithms();
  String disabledAlgorithms=Security.getProperty("jdk.tls.disabledAlgorithms");
  assertNotNull(disabledAlgorithms);
  assertTrue(disabledAlgorithms.contains("TLSv1,"));
  assertTrue(disabledAlgorithms.contains("TLSv1.1,"));
  Security.setProperty("jdk.tls.disabledAlgorithms","");
  System.setProperty("com.vmware.admiral.enable.tlsv1",Boolean.TRUE.toString());
  System.setProperty("com.vmware.admiral.enable.tlsv1.1",Boolean.TRUE.toString());
  SecurityUtils.ensureTlsDisabledAlgorithms();
  disabledAlgorithms=Security.getProperty("jdk.tls.disabledAlgorithms");
  assertNotNull(disabledAlgorithms);
  assertFalse(disabledAlgorithms.contains("TLSv1,"));
  assertFalse(disabledAlgorithms.contains("TLSv1.1,"));
  System.setProperty("com.vmware.admiral.enable.tlsv1",Boolean.FALSE.toString());
  System.setProperty("com.vmware.admiral.enable.tlsv1.1",Boolean.FALSE.toString());
}
