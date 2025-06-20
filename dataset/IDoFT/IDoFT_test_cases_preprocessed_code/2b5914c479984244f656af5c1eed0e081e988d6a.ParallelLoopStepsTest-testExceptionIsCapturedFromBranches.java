@Test public void testExceptionIsCapturedFromBranches() throws Exception {
Assert.assertEquals("Error running: 'nodeName': \n" + "Error running branch: \n" + "Exception details placeholder",exception.getMessage());
}