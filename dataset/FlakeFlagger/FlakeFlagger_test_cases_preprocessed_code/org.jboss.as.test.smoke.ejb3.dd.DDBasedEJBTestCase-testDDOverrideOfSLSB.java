/** 
 * Tests that the overrides in the ejb-jar.xml for a SLSB are honoured, and the bean is invokable through its exposed views
 * @throws Exception
 */
@Test public void testDDOverrideOfSLSB() throws Exception {
Assert.assertEquals("Unexpected return message from bean",msg,echo);
}