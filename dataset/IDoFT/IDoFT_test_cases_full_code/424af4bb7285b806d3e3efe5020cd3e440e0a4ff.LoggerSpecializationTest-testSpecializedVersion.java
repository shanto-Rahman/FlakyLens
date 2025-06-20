@Test public void testSpecializedVersion(){
  startContainer("org/apache/webbeans/test/xml/specializes/alternatives.xml",SystemLogger.class,MockSpecializedLogger.class,SpecializedInjector.class);
  SpecializedInjector injector=getInstance(SpecializedInjector.class);
  ISomeLogger logger=injector.logger();
  Assert.assertTrue(logger instanceof MockSpecializedLogger);
  Assert.assertEquals(MockSpecializedLogger.class,logger.getRealClass());
  logger.printError("Hello World");
  MockSpecializedLogger sysLogger=(MockSpecializedLogger)logger;
  Assert.assertEquals("Hello World",sysLogger.getMessage());
}
