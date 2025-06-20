@Test public void testGetLogger(){
assertThat(logger.getClass().isAssignableFrom(this.loggerClass),is(true));
assertThat(logger.getClass().isAssignableFrom(this.loggerClass),is(true));
}