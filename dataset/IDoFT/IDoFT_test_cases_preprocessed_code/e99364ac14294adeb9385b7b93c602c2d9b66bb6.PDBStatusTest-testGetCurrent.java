@Test public void testGetCurrent() throws IOException {
Assert.assertEquals("4HHB",PDBStatus.getCurrent("1HHB"));
Assert.assertEquals("3HHB",PDBStatus.getCurrent("3HHB"));
Assert.assertNull(PDBStatus.getCurrent("1CMW"));
Assert.assertEquals("3ENI",PDBStatus.getCurrent("1KSA"));
Assert.assertEquals("8CAT",PDBStatus.getCurrent("1CAT"));
Assert.assertEquals("8CAT",PDBStatus.getCurrent("3CAT"));
Assert.assertEquals("7CAT",PDBStatus.getCurrent("7CAT"));
}