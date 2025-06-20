/** 
 * Tests that structures containing symmetry mates with modified chain identifiers can be written out correctly.
 */
@Test public void testBiounitWriting(){
  Structure s=createDummyStructure();
  String mmcif=s.toMMCIF();
  String[] lines=mmcif.split("\n");
  long atomLines=Arrays.stream(lines).filter(l -> l.startsWith("ATOM")).count();
  assertNotNull(mmcif);
  assertEquals(4,atomLines);
}
