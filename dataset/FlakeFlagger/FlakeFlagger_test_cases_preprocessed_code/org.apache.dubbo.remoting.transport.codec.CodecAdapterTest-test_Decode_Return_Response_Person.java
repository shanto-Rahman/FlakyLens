@Test public void test_Decode_Return_Response_Person() throws IOException {
Assert.assertEquals(20,obj.getStatus());
Assert.assertEquals(person,obj.getResult());
}