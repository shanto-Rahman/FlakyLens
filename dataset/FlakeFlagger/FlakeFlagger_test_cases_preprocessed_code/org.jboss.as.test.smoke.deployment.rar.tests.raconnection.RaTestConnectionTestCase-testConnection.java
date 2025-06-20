@Test public void testConnection() throws Exception {
ModelNode testAddress=address.clone();//RW
assertTrue(executeOperation(op).asBoolean());
}