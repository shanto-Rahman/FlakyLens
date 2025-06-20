@Test public void getFromMap(){
assertEquals(expected,found);
fail("Expecting IndexOutOfBoundsException.");
fail("Expecting IndexOutOfBoundsException.");
assertEquals("zeroKey",test.getKey());
assertEquals("zero",test.getValue());
assertEquals("oneKey",test.getKey());
assertEquals("one",test.getValue());
}