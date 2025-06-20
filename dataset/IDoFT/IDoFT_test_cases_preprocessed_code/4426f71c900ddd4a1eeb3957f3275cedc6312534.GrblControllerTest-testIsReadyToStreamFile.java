/** 
 * Test of isReadyToStreamFile method, of class GrblController.
 */
@Test public void testIsReadyToStreamFile() throws Exception {
assertEquals("Grbl has not finished booting.",e.getMessage());
assertTrue(asserted);
assertEquals(true,result);
assertEquals("Cannot stream while there are active commands: ",e.getMessage());
assertTrue(asserted);
}