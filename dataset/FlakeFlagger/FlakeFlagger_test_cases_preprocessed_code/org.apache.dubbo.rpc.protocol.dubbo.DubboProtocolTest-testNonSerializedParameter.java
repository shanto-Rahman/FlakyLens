@Test public void testNonSerializedParameter() throws Exception {
Assert.fail();
Assert.assertTrue(e.getMessage().contains("org.apache.dubbo.rpc.protocol.dubbo.support.NonSerialized must implement java.io.Serializable"));
}