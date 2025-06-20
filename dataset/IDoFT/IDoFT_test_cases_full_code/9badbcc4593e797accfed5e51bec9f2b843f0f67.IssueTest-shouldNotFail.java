@Test public void shouldNotFail(){
  Validator validator=ValidatorBuilder.create().with(new GetterTester()).with(new SetterTester()).build();
  final PojoClass pojoClass=PojoClassFactory.getPojoClass(AClassWithXMLGregorianCalendar.class);
  validator.validate(pojoClass);
  Assert.assertThat(appender.getEventsForLogger(GetterTester.class).size(),is(1));
  Assert.assertThat(appender.getEventsForLogger(SetterTester.class).size(),is(1));
  PojoField xmlGregorianCalendarPojoField=pojoClass.getPojoFields().get(0);
  final String message="Testing Field [" + xmlGregorianCalendarPojoField + "] with value [";
  validateLogMessages(appender,GetterTester.class,message);
  validateLogMessages(appender,SetterTester.class,message);
}
