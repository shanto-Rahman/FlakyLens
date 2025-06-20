@Test public void testValidationWithoutJSR303(){
fail("Expected exception");
assertEquals(1,bex.getErrorCount());
}