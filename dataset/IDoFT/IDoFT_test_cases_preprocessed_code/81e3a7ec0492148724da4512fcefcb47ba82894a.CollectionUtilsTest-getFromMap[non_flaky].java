@Test public void getFromMap(){
assertTrue(entry.toString().equals("zeroKey=zero") || entry.toString().equals("oneKey=one"));
assertTrue(entry.toString().equals("zeroKey=zero") || entry.toString().equals("oneKey=one"));
fail("Expecting IndexOutOfBoundsException.");
fail("Expecting IndexOutOfBoundsException.");
assertEquals("zeroKey",test.getKey());
assertEquals("zero",test.getValue());
assertEquals("oneKey",test.getKey());
assertEquals("one",test.getValue());
}