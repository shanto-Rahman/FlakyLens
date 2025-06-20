/** 
 * Unlike  {@link #testGetResources()}, the URL should begin with file:... before the jar file gets cached
 */
public void testGetResources_precache() throws Exception {
assertTrue(lines[0],lines[0].startsWith("file:"));
assertTrue(lines[1],lines[1].startsWith("file:"));
assertTrue(lines[0],lines[0].endsWith("::hello"));
assertTrue(lines[1],lines[1].endsWith("::hello2"));
}