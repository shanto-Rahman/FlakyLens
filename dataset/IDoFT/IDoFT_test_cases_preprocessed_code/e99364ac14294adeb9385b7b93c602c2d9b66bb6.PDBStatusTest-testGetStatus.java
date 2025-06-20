/** 
 * Test  {@link PDBStatus#getStatus(String)}. <p>Uses the following PDBs:<br/> <pre>1HHB    OBSOLETE	replacedBy=4HHB 4HHB    CURRENT	replaces=1HHB 3HHB    CURRENT	replaces=1HHB </pre>
 */
@Test public void testGetStatus() throws IOException {
Assert.assertEquals(Status.REMOVED,PDBStatus.getStatus("1HHB"));
Assert.assertEquals(Status.CURRENT,PDBStatus.getStatus("3HHB"));
Assert.assertEquals(Status.CURRENT,PDBStatus.getStatus("4HHB"));
}