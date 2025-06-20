/** 
 * AS7-1200 test case for xa datasource persistence to xml
 * @throws Exception
 */
@Test public void testMarshallUnmarshallXaDs() throws Exception {
Assert.assertNotNull("Reparsing failed:",newList);
Assert.assertNotNull(findNodeWithProperty(newList,"jndi-name","java:jboss/datasources/" + jndiDsName));
}