/** 
 * Test ACL operations on a directory, including default ACLs. General strategy is to use GETFILESTATUS and GETACLSTATUS to verify: <ol> <li>Initial status with no ACLs</li> <li>The addition of a default ACL</li> <li>The removal of default ACLs</li> </ol>
 * @throws Exception
 */
@Test @TestDir @TestJetty @TestHdfs public void testDirAcls() throws Exception {
Assert.assertEquals(-1,statusJson.indexOf("aclBit"));
Assert.assertTrue(aclEntries.size() == 0);
Assert.assertTrue(aclEntries.size() == 5);
Assert.assertTrue(aclEntries.contains(defUser1));
Assert.assertEquals(-1,statusJson.indexOf("aclBit"));
Assert.assertTrue(aclEntries.size() == 0);
}