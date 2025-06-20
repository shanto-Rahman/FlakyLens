@Test public void test1OFX() throws StructureException, IOException {
assertEquals(2,s.getPolyChains().size());
assertEquals("A",a.getId());
assertEquals(10,ngrA.size());
assertEquals("B",b.getId());
assertEquals(10,ngrB.size());
}