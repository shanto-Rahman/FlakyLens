@Test public void addressesDoubleValuedPreservesOrder(){
assertNull(this.properties.getHost());
assertEquals("myhost:9999,ahost:1111",this.properties.getAddresses());
}