public void testSelect_multiInvokers(String lbname) throws Exception {
Assert.assertTrue(runs > min);
Assert.assertEquals(true,sinvoker.isAvailable());
Assert.assertEquals(true,sinvoker.isAvailable());
Assert.assertEquals(true,sinvoker.isAvailable());
Assert.assertEquals(true,sinvoker.isAvailable());
Assert.assertEquals(true,sinvoker.isAvailable());
Assert.assertEquals(true,sinvoker.isAvailable());
}