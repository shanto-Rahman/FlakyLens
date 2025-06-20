@Test public void testTerminateBits() throws WriterException {
assertEquals("",v.toString());
assertEquals(" ........",v.toString());
assertEquals(" ........",v.toString());
assertEquals(" ........",v.toString());
assertEquals(" ........",v.toString());
assertEquals(" ........ XXX.XX..",v.toString());
assertEquals(" ........ XXX.XX.. ...X...X",v.toString());
}