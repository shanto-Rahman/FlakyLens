@Test public void test_MultiObject() throws Exception {
assertEquals(false,deserialize.readBool());
assertEquals(bigPerson,deserialize.readObject());
assertEquals((byte)23,deserialize.readByte());
assertEquals(mediaContent,deserialize.readObject());
assertEquals(-23,deserialize.readInt());
fail();
}