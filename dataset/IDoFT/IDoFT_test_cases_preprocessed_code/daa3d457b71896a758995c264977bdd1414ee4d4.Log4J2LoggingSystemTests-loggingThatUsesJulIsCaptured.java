@Test public void loggingThatUsesJulIsCaptured(){
assertThat(output).contains("Hello world");
}