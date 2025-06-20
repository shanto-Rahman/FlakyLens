@Test public void testInvokerNonJsonNonPojoSerialization(){
assertArrayEquals(new String[]{"High"},(String[])filterResult.getValue());
}