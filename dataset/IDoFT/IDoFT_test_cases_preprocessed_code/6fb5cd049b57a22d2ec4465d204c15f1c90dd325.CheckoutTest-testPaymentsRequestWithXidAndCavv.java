@Test public void testPaymentsRequestWithXidAndCavv() throws Exception {
assertNotNull(response);
assertEquals("12345",response.getPspReference());
assertFalse(captor.getValue().contains("\"mpiData\":{\"cavv\":\"AQIDBAUGBwgJCgsMDQ4PEBESExQ\\u003d\",\"xid\":\"AQIDBAUGBwgJCgsMDQ4PEBESExQ\\u003d\"}"));
assertTrue(captor.getValue().contains("\"mpiData\":{\"cavv\":\"AQIDBAUGBwgJCgsMDQ4PEBESExQ=\",\"xid\":\"AQIDBAUGBwgJCgsMDQ4PEBESExQ=\"}"));
}