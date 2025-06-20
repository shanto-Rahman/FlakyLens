@Test public void addressesSingleValuedWithCredentials(){
assertEquals("otherhost",this.properties.getHost());
assertEquals(1111,this.properties.getPort());
assertEquals("root",this.properties.getUsername());
assertEquals("host",this.properties.getVirtualHost());
}