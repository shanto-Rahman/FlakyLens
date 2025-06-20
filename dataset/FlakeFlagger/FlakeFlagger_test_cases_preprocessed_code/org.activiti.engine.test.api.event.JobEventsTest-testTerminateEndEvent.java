@Deployment public void testTerminateEndEvent() throws Exception {
assertEquals("Inside Task",task.getName());
if (ActivitiEventType.PROCESS_CANCELLED.equals(eventReceived.getType())) {
fail("Should not have received PROCESS_CANCELLED event");
}
if (ActivitiEventType.ACTIVITY_CANCELLED.equals(eventReceived.getType())) {
if (!"userTask".equals(activityType) && (!"subProcess".equals(activityType)) && (!"endEvent".equals(activityType))) {
fail("Unexpected activity type: " + activityType);
}
}
assertEquals("Outside Task",task.getName());
}