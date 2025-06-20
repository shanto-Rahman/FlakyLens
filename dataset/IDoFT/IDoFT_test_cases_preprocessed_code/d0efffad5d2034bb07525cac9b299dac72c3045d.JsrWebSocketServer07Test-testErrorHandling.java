@Test public void testErrorHandling() throws Exception {
Assert.assertEquals("hi",ProgramaticErrorEndpoint.getMessage());
Assert.assertEquals("app-error",ProgramaticErrorEndpoint.getMessage());
Assert.assertEquals("ERROR: java.lang.RuntimeException",ProgramaticErrorEndpoint.getMessage());
Assert.assertTrue(c.isOpen());
Assert.assertEquals("io-error",ProgramaticErrorEndpoint.getMessage());
Assert.assertEquals("ERROR: java.lang.RuntimeException",ProgramaticErrorEndpoint.getMessage());
Assert.assertTrue(c.isOpen());
Assert.assertEquals("CLOSED",ProgramaticErrorEndpoint.getMessage());
}