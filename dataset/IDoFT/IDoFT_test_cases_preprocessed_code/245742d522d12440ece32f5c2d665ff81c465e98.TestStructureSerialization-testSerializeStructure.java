@Test public void testSerializeStructure() throws IOException, StructureException, ClassNotFoundException {
assertEquals(sin.nrModels(),sout.nrModels());
assertEquals(sin.getChains().size(),sout.getChains().size());
assertEquals(sin.getName(),sout.getName());
assertEquals(sin.toString(),sout.toString());
}