@Test public void testSystemProperties() throws Exception {
Assert.assertNotNull("Property " + var + " is not set (in container).",path);
File dir=new File(path);//RO
Assert.assertTrue("Directory " + dir.getAbsolutePath() + " doesn't exist, check Surefire's system property "+ var,dir.exists());
}