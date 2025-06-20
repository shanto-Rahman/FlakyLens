/** 
 * Test expiration of KeyValues in combination with a configured TTL for a column family (as should be triggered in a major compaction).
 */
public void testWildCardTtlScan() throws IOException {
assertEquals(true,scanner.next(results));
assertEquals(2,results.size());
assertEquals(kvs[1],results.get(0));
assertEquals(kvs[2],results.get(1));
assertEquals(true,scanner.next(results));
assertEquals(3,results.size());
assertEquals(kvs[4],results.get(0));
assertEquals(kvs[5],results.get(1));
assertEquals(kvs[6],results.get(2));
assertEquals(false,scanner.next(results));
}