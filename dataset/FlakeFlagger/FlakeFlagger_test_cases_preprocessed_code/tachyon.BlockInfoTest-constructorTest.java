@Test public void constructorTest(){
Assert.assertEquals(tInfo.BLOCK_INDEX,300);
Assert.assertEquals(tInfo.BLOCK_ID,BlockInfo.computeBlockId(100,300));
Assert.assertEquals(tInfo.OFFSET,(long)Constants.DEFAULT_BLOCK_SIZE_BYTE * 300);
Assert.assertEquals(tInfo.LENGTH,800);
}