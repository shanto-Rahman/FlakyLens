@Test public void testRequestTargetHostConnectHttp11() throws Exception {
Assert.assertNotNull(header);
Assert.assertEquals("somehost:8080",header.getValue());
}