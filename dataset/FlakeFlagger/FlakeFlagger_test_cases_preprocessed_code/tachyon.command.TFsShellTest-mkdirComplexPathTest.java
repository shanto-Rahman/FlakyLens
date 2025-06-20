@Test public void mkdirComplexPathTest() throws IOException {
Assert.assertNotNull(tFile);
Assert.assertEquals(getCommandOutput(new String[]{"mkdir","/Complex!@#$%^&*()-_=+[]{};\"'<>,.?/File"}),mOutput.toString());
Assert.assertTrue(tFile.isDirectory());
}