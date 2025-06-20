@Test public void processSampleContentWithManyOptions() throws Exception {
cssLint.validate(IOUtils.toString(new FileInputStream(url.getFile())));
Assert.fail("should have failed!");
Assert.assertEquals(30,e.getErrors().size());
}