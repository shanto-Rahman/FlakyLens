@Test public void getAliases(){
assertTrue(result.toString(),result.contains(this.hostName));
assertTrue(result.toString(),result.contains(this.alias));
}