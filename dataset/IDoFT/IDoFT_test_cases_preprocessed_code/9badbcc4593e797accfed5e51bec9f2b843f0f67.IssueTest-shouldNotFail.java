@Test public void shouldNotFail(){
Assert.assertThat(appender.getEventsForLogger(GetterTester.class).size(),is(1));
Assert.assertThat(appender.getEventsForLogger(SetterTester.class).size(),is(1));
}