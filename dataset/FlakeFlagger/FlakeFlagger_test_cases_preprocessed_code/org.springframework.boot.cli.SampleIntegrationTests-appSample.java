@Test public void appSample() throws Exception {
URI scriptUri=new File("samples/app.groovy").toURI();//RO
assertTrue("Wrong output: " + output,output.contains("Hello World! From " + scriptUri));
}