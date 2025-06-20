@Test public void testPrudentModeLogicalImplications(){
File file=new File(filename);//RO
assertTrue(appender.isAppend());
assertEquals(Status.WARN,statusChecker.getHighestLevel(0));
assertTrue("Expecting status list size to be 2 or larger, but was " + statusList.size(),statusList.size() >= 2);
assertTrue("Got message [" + msg1 + "]",msg1.startsWith("Setting \"Append\" property"));
assertTrue(file.exists());
assertTrue("failed to delete " + file.getAbsolutePath(),file.delete());
}