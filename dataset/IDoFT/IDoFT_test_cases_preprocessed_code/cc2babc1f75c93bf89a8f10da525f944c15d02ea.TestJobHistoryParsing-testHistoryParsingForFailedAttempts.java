@Test(timeout=30000) public void testHistoryParsingForFailedAttempts() throws Exception {
Assert.assertNull("Caught an expected exception " + parseException,parseException);
Assert.assertEquals("rack-name is incorrect",taskAttemptInfo.getRackname(),RACK_NAME);
if (taskAttemptInfo.getTaskStatus().equals("FAILED")) {
}
Assert.assertEquals("No of Failed tasks doesn't match.",2,noOffailedAttempts);
}