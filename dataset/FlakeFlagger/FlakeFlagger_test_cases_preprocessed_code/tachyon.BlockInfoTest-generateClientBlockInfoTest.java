@Test public void generateClientBlockInfoTest(){
Assert.assertEquals((long)Constants.DEFAULT_BLOCK_SIZE_BYTE * 300,clientBlockInfo.offset);
Assert.assertEquals(800,clientBlockInfo.length);
Assert.assertEquals(3,clientBlockInfo.locations.size());
}