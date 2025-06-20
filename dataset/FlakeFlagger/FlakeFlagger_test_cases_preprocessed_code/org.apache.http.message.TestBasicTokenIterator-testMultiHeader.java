@Test public void testMultiHeader(){
Assert.assertTrue(ti.hasNext());
Assert.assertEquals("token0","token0",ti.nextToken());
Assert.assertTrue(ti.hasNext());
Assert.assertEquals("token1","token1",ti.nextToken());
Assert.assertTrue(ti.hasNext());
Assert.assertEquals("token2","token2",ti.nextToken());
Assert.assertTrue(ti.hasNext());
Assert.assertEquals("token3","token3",ti.nextToken());
Assert.assertTrue(ti.hasNext());
Assert.assertEquals("token4","token4",ti.nextToken());
Assert.assertFalse(ti.hasNext());
}