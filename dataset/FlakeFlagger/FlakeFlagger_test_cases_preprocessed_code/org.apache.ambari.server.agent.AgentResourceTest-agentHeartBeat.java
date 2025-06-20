@Test public void agentHeartBeat() throws UniformInterfaceException, JSONException {
LOG.info("Returned from Server: " + " response=" + response);//RW
Assert.assertEquals(response.getResponseId(),0L);
}