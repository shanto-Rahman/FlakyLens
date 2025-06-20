public void testPutSameKey(){
assertEquals(1,this.memstore.kvset.size());
assertTrue(Bytes.toString(found.getValue()),Bytes.equals(samekey.getValue(),found.getValue()));
}