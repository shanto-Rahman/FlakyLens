@Test public void fileinfoTest() throws IOException {
Assert.assertNotNull(tFile);
Assert.assertEquals(getCommandOutput(commandParameters),mOutput.toString());
}