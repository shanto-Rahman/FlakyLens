@Test public void testCheckSide(){
Assert.assertFalse(context.isConsumerSide());
Assert.assertTrue(context.isProviderSide());
Assert.assertTrue(context.isConsumerSide());
Assert.assertFalse(context.isProviderSide());
}