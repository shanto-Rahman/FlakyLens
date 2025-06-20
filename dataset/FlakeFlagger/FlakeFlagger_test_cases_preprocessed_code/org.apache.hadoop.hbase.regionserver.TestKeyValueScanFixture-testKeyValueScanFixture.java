public void testKeyValueScanFixture(){
assertNull(scan.peek());
assertTrue(scan.seek(kv));
assertEquals(kvs[0],res);
assertTrue(scan.seek(kv));
assertEquals(kvs[2],res);
assertTrue(scan.seek(kv));
assertEquals(kvs[0],scan.peek());
assertEquals(kvs[0],scan.next());
assertEquals(kvs[1],scan.peek());
assertEquals(kvs[1],scan.next());
assertEquals(kvs[2],scan.peek());
assertEquals(kvs[2],scan.next());
assertEquals(null,scan.peek());
assertEquals(null,scan.next());
}