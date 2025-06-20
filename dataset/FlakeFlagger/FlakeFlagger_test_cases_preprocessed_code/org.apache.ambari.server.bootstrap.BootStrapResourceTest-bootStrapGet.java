@Test public void bootStrapGet() throws UniformInterfaceException, JSONException {
LOG.info("GET Response from the API " + status.getLog() + " "+ status.getStatus());//RW
Assert.assertEquals(status.getStatus(),BSStat.ERROR);
}