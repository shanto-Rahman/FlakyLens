/** 
 * Validate the various ACL set/modify/remove calls.  General strategy is to verify each of the following steps with GETFILESTATUS, LISTSTATUS, and GETACLSTATUS: <ol> <li>Create a file with no ACLs</li> <li>Add a user + group ACL</li> <li>Add another user ACL</li> <li>Remove the first user ACL</li> <li>Remove all ACLs</li> </ol>
 */
@Test @TestDir @TestJetty @TestHdfs public void testFileAcls() throws Exception {
Assert.assertEquals(-1,statusJson.indexOf("aclBit"));
Assert.assertEquals(-1,statusJson.indexOf("aclBit"));
Assert.assertTrue(aclEntries.size() == 0);
Assert.assertTrue(aclEntries.size() == 2);
Assert.assertTrue(aclEntries.contains(aclUser1));
Assert.assertTrue(aclEntries.contains(aclGroup1));
Assert.assertTrue(aclEntries.size() == 3);
Assert.assertTrue(aclEntries.contains(aclUser1));
Assert.assertTrue(aclEntries.contains(aclUser2));
Assert.assertTrue(aclEntries.contains(aclGroup1));
Assert.assertTrue(aclEntries.size() == 2);
Assert.assertTrue(aclEntries.contains(aclUser2));
Assert.assertTrue(aclEntries.contains(aclGroup1));
Assert.assertTrue(aclEntries.size() == 0);
Assert.assertEquals(-1,statusJson.indexOf("aclBit"));
Assert.assertEquals(-1,statusJson.indexOf("aclBit"));
}