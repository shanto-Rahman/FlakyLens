@Test public void charset(){
assertEquals(Charset.forName("UTF-8"),house.getCharset());
assertNull(house.getCharset());
}