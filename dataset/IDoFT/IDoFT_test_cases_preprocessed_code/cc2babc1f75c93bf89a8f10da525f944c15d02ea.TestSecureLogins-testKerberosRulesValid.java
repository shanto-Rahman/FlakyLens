@Test public void testKerberosRulesValid() throws Throwable {
assertTrue("!KerberosName.hasRulesBeenSet()",KerberosName.hasRulesBeenSet());
assertEquals(kerberosRule,rules);
}