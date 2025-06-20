@Test public void addLogPathProperty(){
assertTrue("Wrong output:\n" + output,output.startsWith("target/foo/spring.log"));
}