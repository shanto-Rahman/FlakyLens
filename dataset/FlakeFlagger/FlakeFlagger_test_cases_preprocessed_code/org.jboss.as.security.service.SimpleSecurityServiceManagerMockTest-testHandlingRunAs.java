/** 
 * Even if outgoing RunAs from previous state is empty, incoming RunAs has to be used for incomingRunAs for current state.
 * @param incomingRunAs  Incoming RunAs for previous state.
 * @param outgoingRunAs  Outgoung RunAs for previous state.
 */
private void testHandlingRunAs(RunAs incomingRunAs,RunAs outgoingRunAs){
if (outgoingRunAs != null) {
}
if (incomingRunAs != null) {
}
if (outgoingRunAs != null) {
Assert.assertEquals("RunAs identity has to be same as previous outgoing RunAs.",outgoingRunAs,result.getIncomingRunAs());
if (incomingRunAs != null) {
Assert.assertEquals("RunAs identity has to be same as previous incoming RunAs.",incomingRunAs,result.getIncomingRunAs());
Assert.assertNull("RunAs identity has to be null.",result.getIncomingRunAs());
}
}
}