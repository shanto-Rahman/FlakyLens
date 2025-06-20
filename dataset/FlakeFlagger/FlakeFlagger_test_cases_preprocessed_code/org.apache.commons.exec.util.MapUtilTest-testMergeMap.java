/** 
 * Test merging of maps
 */
public void testMergeMap() throws Exception {
assertTrue((procEnvironment.size() + applicationEnvironment.size()) == result.size());
assertEquals("foo.bar.Main",result.get("appMainClass"));
}