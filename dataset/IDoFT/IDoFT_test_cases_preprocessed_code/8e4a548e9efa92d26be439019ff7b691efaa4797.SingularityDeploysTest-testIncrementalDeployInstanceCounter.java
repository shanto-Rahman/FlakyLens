@Test public void testIncrementalDeployInstanceCounter(){
Assertions.assertEquals(1,deployProgress.getTargetActiveInstances());
Assertions.assertEquals(1,deployProgress.getCurrentActiveInstances());
Assertions.assertEquals(2,deployProgress.getTargetActiveInstances());
Assertions.assertEquals(2,deployProgress.getCurrentActiveInstances());
Assertions.assertEquals(3,deployProgress.getTargetActiveInstances());
Assertions.assertEquals(3,deployProgress.getCurrentActiveInstances());
}