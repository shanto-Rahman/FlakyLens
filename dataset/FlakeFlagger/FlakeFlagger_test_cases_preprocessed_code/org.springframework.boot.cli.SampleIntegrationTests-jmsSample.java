@Test public void jmsSample() throws Exception {
assertTrue("Wrong output: " + output,output.contains("Received Greetings from Spring Boot via HornetQ"));
}