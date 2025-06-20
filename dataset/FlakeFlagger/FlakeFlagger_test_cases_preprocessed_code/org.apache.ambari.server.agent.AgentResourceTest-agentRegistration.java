@Test public void agentRegistration() throws UniformInterfaceException, JSONException {
LOG.info("Returned from Server responce=" + response);//RW
Assert.assertEquals(response.getResponseStatus(),RegistrationStatus.OK);
}