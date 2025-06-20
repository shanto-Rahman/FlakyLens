@Test public void testSpecializedVersion(){
Assert.assertTrue(logger instanceof MockSpecializedLogger);
Assert.assertEquals(MockSpecializedLogger.class,logger.getRealClass());
Assert.assertEquals("Hello World",sysLogger.getMessage());
}