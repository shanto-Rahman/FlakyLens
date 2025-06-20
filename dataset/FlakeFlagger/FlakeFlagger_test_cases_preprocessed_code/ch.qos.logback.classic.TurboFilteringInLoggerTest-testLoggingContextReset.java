@Test public void testLoggingContextReset(){
assertNotNull(context.getTurboFilterList().get(0));
assertEquals(0,context.getTurboFilterList().size());
}