@Test public void encodesArray(){
assertEquals("[{\"a\":\"b\",\"c\":1},123]",new String(requestTemplate.body(),UTF_8));
}