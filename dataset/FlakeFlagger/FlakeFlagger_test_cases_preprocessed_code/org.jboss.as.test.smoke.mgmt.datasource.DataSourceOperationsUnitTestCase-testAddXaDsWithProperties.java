/** 
 * AS7-1203 test for missing xa-datasource properties
 * @throws Exception
 */
@Test public void testAddXaDsWithProperties() throws Exception {
Assert.assertNotNull("Reparsing failed:",newList);
Assert.assertNotNull(findNodeWithProperty(newList,"jndi-name",xaDsJndi));
}