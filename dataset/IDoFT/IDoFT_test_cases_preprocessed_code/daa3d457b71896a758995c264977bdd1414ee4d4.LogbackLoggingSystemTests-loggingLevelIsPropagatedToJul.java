@Test public void loggingLevelIsPropagatedToJul(){
assertThat(output).contains("Hello debug world");
}