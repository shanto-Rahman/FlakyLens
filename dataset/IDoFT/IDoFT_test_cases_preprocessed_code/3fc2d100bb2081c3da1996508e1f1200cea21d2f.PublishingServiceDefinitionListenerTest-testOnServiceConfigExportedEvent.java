/** 
 * Test  {@link ServiceConfigExportedEvent} arising
 */
@Test public void testOnServiceConfigExportedEvent(){
assertEquals(serviceDefinition,new Gson().toJson(serviceDefinitionBuild));
}