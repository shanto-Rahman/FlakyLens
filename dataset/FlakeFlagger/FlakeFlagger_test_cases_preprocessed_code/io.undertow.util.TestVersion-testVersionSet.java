@Test public void testVersionSet(){
Assert.assertNotNull(Version.getVersionString());
Assert.assertNotSame("Unknown",version);
}