@Test public void isExpired(){
assertFalse(this.metaData.isExpired());
assertTrue(this.metaData.isExpired());
assertFalse(this.metaData.isExpired());
}