public void testHeadTail() throws Exception {
if (i == 1) splitter=kv;
assertEquals(2,tail.size());
assertEquals(1,head.size());
assertTrue(Bytes.equals(tail.first().getValue(),value2));
assertTrue(Bytes.equals(head.first().getValue(),value2));
}