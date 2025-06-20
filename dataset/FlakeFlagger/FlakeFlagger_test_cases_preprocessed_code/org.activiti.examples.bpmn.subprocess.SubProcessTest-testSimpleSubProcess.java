@Test public void testSimpleSubProcess(){
Assert.assertEquals(2,tasks.size());
Assert.assertEquals("Investigate hardware",investigateHardwareTask.getName());
Assert.assertEquals("Investigate software",investigateSoftwareTask.getName());
Assert.assertEquals("Write report",writeReportTask.getName());
}