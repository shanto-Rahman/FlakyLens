@Test public void test3HBX() throws Exception {
assertTrue("It should not be the case, but it is faster to parse a PDB file (" + timePDB + " ns.) than MMTF ("+ (timeMMTF)+ " ns.)!",(timePDB) > (timeMMTF));
}