@Test public void testGetContext(){
Assert.assertTrue(context != null);
Assert.assertEquals(name,context.getName());
Assert.assertTrue(sysContext != null);
}