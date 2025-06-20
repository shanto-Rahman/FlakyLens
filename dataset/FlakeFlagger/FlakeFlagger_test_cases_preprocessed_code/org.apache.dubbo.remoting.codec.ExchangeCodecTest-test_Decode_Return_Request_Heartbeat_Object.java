@Test public void test_Decode_Return_Request_Heartbeat_Object() throws IOException {
Assert.assertEquals(null,obj.getData());
Assert.assertEquals(true,obj.isTwoWay());
Assert.assertEquals(true,obj.isHeartbeat());
Assert.assertEquals(Version.getProtocolVersion(),obj.getVersion());
}