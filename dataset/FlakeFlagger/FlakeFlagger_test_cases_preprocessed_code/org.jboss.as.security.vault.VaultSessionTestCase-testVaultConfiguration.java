@Test public void testVaultConfiguration(){
Assert.fail("Failed while initializing vault session with exception " + e.getMessage());
Assert.assertEquals(expectedCommand,vaultSession.vaultConfiguration());
}