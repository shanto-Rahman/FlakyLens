@Deployment public void testDeleteCancelledMultiInstanceTasks() throws Exception {
assertNotNull(processInstance);
assertFalse(processInstance.isEnded());
assertNotNull(firstTask);
assertNull(processInstance);
}