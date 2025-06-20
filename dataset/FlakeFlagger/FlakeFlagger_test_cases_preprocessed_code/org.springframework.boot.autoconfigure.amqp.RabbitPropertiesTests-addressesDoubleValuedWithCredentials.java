@Test public void addressesDoubleValuedWithCredentials(){
assertNull(this.properties.getHost());
assertEquals(9999,this.properties.getPort());
assertEquals("root",this.properties.getUsername());
assertEquals("host",this.properties.getVirtualHost());
}