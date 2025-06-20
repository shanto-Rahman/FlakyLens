/** 
 * A selection of structures with no global symmetry, but local symmetry
 * @throws IOException
 * @throws StructureException
 */
@Test public void testLocal() throws IOException, StructureException {
assertEquals("Unexpected global symmetry in " + testIds.get(iTest),"C1",globalSymmetry.getSymmetry());
assertEquals("Unexpected global stoichiometry in " + testIds.get(iTest),testStoichiometries.get(iTest),globalSymmetry.getStoichiometry().toString());
assertTrue("Stoichiometry " + local.getStoichiometry().toString() + " not expected for "+ testIds.get(iTest),refLocal.containsKey(local.getStoichiometry().toString()));
assertEquals("Symmetry " + local.getSymmetry() + " with stoichiometry "+ local.getStoichiometry().toString()+ " not expected for "+ testIds.get(iTest),refLocal.get(local.getStoichiometry().toString()),local.getSymmetry());
}