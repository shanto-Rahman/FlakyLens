@Deployment public void testThrowMessageInterrupting() throws Exception {
assertNotNull(processInstance);
assertNotNull(task);
assertNull(task);
assertNotNull(boundaryTask);
}