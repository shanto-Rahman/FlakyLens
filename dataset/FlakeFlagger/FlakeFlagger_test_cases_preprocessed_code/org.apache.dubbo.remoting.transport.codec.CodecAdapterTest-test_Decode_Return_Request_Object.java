@Test public void test_Decode_Return_Request_Object() throws IOException {
Assert.assertEquals(person,obj.getData());
Assert.assertEquals(true,obj.isTwoWay());
Assert.assertEquals(false,obj.isHeartbeat());
Assert.assertEquals(Version.getProtocolVersion(),obj.getVersion());
}