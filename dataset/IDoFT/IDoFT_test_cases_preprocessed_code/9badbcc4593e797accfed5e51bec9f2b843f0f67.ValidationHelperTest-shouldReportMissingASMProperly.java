@Test public void shouldReportMissingASMProperly(){
Assert.assertEquals(1,warnEvents.size());
Assert.assertEquals(expectedMessage,warnEvents.get(0).getMessage());
}