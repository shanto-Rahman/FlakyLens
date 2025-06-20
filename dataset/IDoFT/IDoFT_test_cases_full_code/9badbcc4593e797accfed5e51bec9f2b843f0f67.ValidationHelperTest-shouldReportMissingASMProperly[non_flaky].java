@Test public void shouldReportMissingASMProperly(){
  LoggerFactory.setActiveLogger(Log4JLogger.class);
  Validator validator=ValidatorBuilder.create().with(new Tester(){
    public void run(    PojoClass pojoClass){
      throw ASMNotLoadedException.getInstance();
    }
  }
).build();
  LogHelper.initialize(MockAppenderLog4J.class);
  validator.validate(PojoClassFactory.getPojoClass(this.getClass()));
  List<LogEvent> warnEvents=LogHelper.getWarnEvents(MockAppenderLog4J.class,DefaultValidator.class.getName());
  Assert.assertEquals(1,warnEvents.size());
  String expectedMessage="ASM not loaded while attempting to execute behavioural tests on non-constructable class[" + this.getClass() + "], either filter abstract classes or add asm to your classpath.";
  Assert.assertEquals(expectedMessage,warnEvents.get(0).getMessage());
}
