/** 
 * @throws Exception  
 */
public void testGetRowMultipleVersions() throws Exception {
assertNotNull(r);
assertFalse(r.isEmpty());
assertTrue(r.size() == 1);
assertTrue(value.length != 0);
assertTrue(Bytes.equals(value,VALUE2));
assertTrue(r.size() == 2);
assertTrue(value.length != 0);
assertTrue(Bytes.equals(value,VALUE2));
assertTrue(versionMap.size() == 2);
assertTrue(Bytes.equals(VALUE1,versionMap.get(TIMESTAMP1)));
assertTrue(Bytes.equals(VALUE2,versionMap.get(TIMESTAMP2)));
}