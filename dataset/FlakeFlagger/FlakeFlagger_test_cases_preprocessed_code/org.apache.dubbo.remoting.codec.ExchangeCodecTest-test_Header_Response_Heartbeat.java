@Test public void test_Header_Response_Heartbeat() throws IOException {
Assert.assertEquals(20,obj.getStatus());
Assert.assertEquals(person,obj.getResult());
}