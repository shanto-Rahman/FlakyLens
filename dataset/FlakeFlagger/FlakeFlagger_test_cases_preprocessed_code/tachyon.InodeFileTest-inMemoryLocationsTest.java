@Test public void inMemoryLocationsTest() throws IOException, BlockInfoException {
Assert.assertEquals(1,inodeFile.getBlockLocations(0).size());
Assert.assertEquals(2,inodeFile.getBlockLocations(0).size());
Assert.assertEquals(3,inodeFile.getBlockLocations(0).size());
Assert.assertEquals(testAddresses,inodeFile.getBlockLocations(0));
}