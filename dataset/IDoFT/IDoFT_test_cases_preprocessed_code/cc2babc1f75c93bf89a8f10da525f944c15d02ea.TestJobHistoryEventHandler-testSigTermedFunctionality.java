@Test public void testSigTermedFunctionality() throws IOException {
assertTrue("handleEvent should've been called only 4 times but was " + jheh.eventsHandled,jheh.eventsHandled == 4);
assertTrue("handleEvent should've been called only 5 times but was " + jheh.eventsHandled,jheh.eventsHandled == 5);
assertTrue("Last event handled wasn't JobUnsuccessfulCompletionEvent",jheh.lastEventHandled.getHistoryEvent() instanceof JobUnsuccessfulCompletionEvent);
}