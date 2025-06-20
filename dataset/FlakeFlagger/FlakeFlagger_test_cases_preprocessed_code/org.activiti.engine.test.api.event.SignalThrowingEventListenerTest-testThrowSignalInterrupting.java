@Deployment public void testThrowSignalInterrupting() throws Exception {
assertNotNull(processInstance);
assertNotNull(task);
assertNull(task);
assertNotNull(boundaryTask);
}