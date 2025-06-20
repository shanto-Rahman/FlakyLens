@Test public void mkdirTest() throws IOException {
Assert.assertNotNull(tFile);
Assert.assertEquals(getCommandOutput(new String[]{"mkdir","/root/testFile1"}),mOutput.toString());
Assert.assertTrue(tFile.isDirectory());
}