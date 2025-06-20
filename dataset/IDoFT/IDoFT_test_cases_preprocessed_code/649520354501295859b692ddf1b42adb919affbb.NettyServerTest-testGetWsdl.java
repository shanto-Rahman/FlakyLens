@Test public void testGetWsdl() throws Exception {
assertTrue("Expect the SOAPService",result.indexOf("<service name=\"SOAPService\">") > 0);
}