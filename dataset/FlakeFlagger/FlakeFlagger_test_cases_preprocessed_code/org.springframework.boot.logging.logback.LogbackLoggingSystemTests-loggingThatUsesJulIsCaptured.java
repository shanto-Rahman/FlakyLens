@Test public void loggingThatUsesJulIsCaptured(){
assertTrue("Wrong output:\n" + output,output.contains("Hello world"));
}