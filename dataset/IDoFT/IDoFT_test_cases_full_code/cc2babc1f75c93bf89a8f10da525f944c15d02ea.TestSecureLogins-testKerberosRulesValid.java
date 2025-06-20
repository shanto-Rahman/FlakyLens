@Test public void testKerberosRulesValid() throws Throwable {
  assertTrue("!KerberosName.hasRulesBeenSet()",KerberosName.hasRulesBeenSet());
  String rules=KerberosName.getRules();
  assertEquals(kerberosRule,rules);
  LOG.info(rules);
}
