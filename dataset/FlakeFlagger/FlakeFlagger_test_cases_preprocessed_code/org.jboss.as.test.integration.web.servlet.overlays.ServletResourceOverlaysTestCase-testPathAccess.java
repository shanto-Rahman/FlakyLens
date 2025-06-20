/** 
 * Tests that a servlet (through the use of    {@link javax.servlet.ServletContext#getResourceAsStream(String)}  (or similar APIs)cannot access paths outside of the deployment
 * @throws Exception
 */
@Test public void testPathAccess() throws Exception {
assertEquals("Unexpected result from call to " + aTxtPath,PathAccessCheckServlet.ACCESS_CHECKS_CORRECTLY_VALIDATED,aTxtAccess);
if (fileUnderTest.exists()) {
if (File.separator.equals("\\")) {
}
assertEquals("Unexpected result from call to " + pathOutsideOfDeployment,PathAccessCheckServlet.ACCESS_CHECKS_CORRECTLY_VALIDATED,outsidePathAccessCheck);
fail("Cannot create the file under test: " + fileUnderTest.getCanonicalPath());
}
}