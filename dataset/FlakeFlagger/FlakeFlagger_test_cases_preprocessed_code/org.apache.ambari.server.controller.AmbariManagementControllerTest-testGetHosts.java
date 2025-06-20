@Test public void testGetHosts() throws AmbariException {
Assert.assertEquals(4,resps.size());
if (resp.getHostname().equals("h1")) {
Assert.assertEquals(2,resp.getClusterNames().size());
Assert.assertEquals(0,resp.getHostAttributes().size());
if (resp.getHostname().equals("h2")) {
Assert.assertEquals(1,resp.getClusterNames().size());
Assert.assertEquals(0,resp.getHostAttributes().size());
if (resp.getHostname().equals("h3")) {
Assert.assertEquals(1,resp.getClusterNames().size());
Assert.assertEquals(1,resp.getHostAttributes().size());
if (resp.getHostname().equals("h4")) {
Assert.assertEquals(0,resp.getClusterNames().size());
Assert.assertEquals(2,resp.getHostAttributes().size());
fail("Found invalid host");
}
}
}
}
Assert.assertEquals(4,foundHosts.size());
Assert.assertEquals(1,resps.size());
Assert.assertEquals("h1",resp.getHostname());
Assert.assertEquals(2,resp.getClusterNames().size());
Assert.assertEquals(0,resp.getHostAttributes().size());
}