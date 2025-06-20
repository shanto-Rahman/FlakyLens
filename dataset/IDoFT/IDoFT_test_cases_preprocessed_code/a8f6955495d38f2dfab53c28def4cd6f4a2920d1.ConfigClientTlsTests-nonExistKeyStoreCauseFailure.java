@Test(expected=IllegalStateException.class) public void nonExistKeyStoreCauseFailure(){
client.setKeyStore(new File("nonExistFile"));//RO
}