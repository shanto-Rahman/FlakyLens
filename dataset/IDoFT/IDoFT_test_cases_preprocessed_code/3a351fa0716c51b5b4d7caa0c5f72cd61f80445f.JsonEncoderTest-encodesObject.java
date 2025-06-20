@Test public void encodesObject(){
assertEquals("{\"a\":\"b\",\"c\":1}",new String(requestTemplate.body(),UTF_8));
}