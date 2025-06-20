/** 
 * Tests that all possible local view bindings of a Stateless bean are available.
 * @throws Exception
 */
@Test public void testLocalBindingsOnSLSB() throws Exception {
Assert.assertEquals("Unexpected return message from bean",msg,echo);
}