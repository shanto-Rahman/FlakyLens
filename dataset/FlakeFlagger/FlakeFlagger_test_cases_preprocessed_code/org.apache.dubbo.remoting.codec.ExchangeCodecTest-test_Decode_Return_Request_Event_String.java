@Test public void test_Decode_Return_Request_Event_String() throws IOException {
Assert.assertEquals(event,obj.getData());
Assert.assertEquals(true,obj.isTwoWay());
Assert.assertEquals(true,obj.isEvent());
Assert.assertEquals(Version.getProtocolVersion(),obj.getVersion());
}