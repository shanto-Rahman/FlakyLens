@Test public void testClose() throws Exception {
  Properties props=System.getProperties();
  props.setProperty(Config.FLUENT_SENDER_CLASS,NullSender.class.getName());
  FluentLogger.getLogger("tag1");
  FluentLogger.getLogger("tag2");
  FluentLogger.getLogger("tag3");
  Map<FluentLogger,String> loggers;
{
    loggers=FluentLogger.getLoggers();
    assertEquals(3,loggers.size());
  }
  FluentLogger.closeAll();
{
    loggers=FluentLogger.getLoggers();
    assertEquals(0,loggers.size());
  }
  props.remove(Config.FLUENT_SENDER_CLASS);
}
