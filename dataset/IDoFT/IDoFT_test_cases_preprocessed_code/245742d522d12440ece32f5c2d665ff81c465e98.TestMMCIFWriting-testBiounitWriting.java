/** 
 * Tests that structures containing symmetry mates with modified chain identifiers can be written out correctly.
 */
@Test public void testBiounitWriting(){
assertNotNull(mmcif);
assertEquals(4,atomLines);
}