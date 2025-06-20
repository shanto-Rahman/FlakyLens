@Test public void testGenerateDescription2(){
assertTrue(actual.indexOf("ConfigurationStore is injected") > 0);
assertTrue(actual.indexOf("Produces Integer") > 0);
assertTrue(actual.indexOf("Produces Boolean") > 0);
assertTrue(actual.indexOf("Produces String") > 0);
assertTrue(actual.indexOf("Produces String[]") > 0);
}