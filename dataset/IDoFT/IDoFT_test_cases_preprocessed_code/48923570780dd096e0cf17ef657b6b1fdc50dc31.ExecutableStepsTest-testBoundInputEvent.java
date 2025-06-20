@Test public void testBoundInputEvent(){
assertFalse(events.isEmpty());
if (event.getEventType().equals(ScoreLangConstants.EVENT_INPUT_END)) {
}
assertNotNull(boundInputEvent);
assertTrue(eventData.containsKey(LanguageEventData.BOUND_INPUTS));
assertNotNull(eventData.getStepName());
assertEquals(LanguageEventData.StepType.FLOW,eventData.getStepType());
assertEquals("dockerizeStep",eventData.getStepName());
assertEquals("Inputs are not in defined order in end inputs binding event","input1",firstInput.getKey());
assertEquals(5,firstInput.getValue());
assertEquals("Inputs are not in defined order in end inputs binding event","input2",secondInput.getKey());
assertEquals(SensitiveValue.SENSITIVE_VALUE_MASK,secondInput.getValue());
}