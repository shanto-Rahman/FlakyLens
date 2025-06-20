@Test public void testHex(){
assertThat(b1,is(Bytes.hex2bytes(str)));
}