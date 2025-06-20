@Test public void locationTest() throws IOException {
Assert.assertNotNull(tFile);
Assert.assertEquals(getCommandOutput(commandParameters),mOutput.toString());
}