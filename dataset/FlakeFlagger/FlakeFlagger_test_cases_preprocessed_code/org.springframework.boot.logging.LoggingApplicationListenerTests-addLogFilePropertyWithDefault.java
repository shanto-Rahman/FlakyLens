@Test public void addLogFilePropertyWithDefault(){
assertFalse(new File("target/foo.log").exists());//RO
assertTrue(new File("target/foo.log").exists());//RO
}