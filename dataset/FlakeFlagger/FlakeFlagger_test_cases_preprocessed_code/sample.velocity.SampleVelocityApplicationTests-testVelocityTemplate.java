@Test public void testVelocityTemplate() throws Exception {
String result=SampleVelocityApplicationTests.output.toString();//RW
assertTrue("Wrong output: " + result,result.contains("Hello, Andy"));
}