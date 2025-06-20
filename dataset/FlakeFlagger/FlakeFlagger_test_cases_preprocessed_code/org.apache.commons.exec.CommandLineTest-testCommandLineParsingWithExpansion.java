/** 
 * Test expanding the command line based on a user-supplied map.
 */
public void testCommandLineParsingWithExpansion(){
assertTrue(cmdl.getExecutable().indexOf("${JAVA_HOME}") == 0);
assertEquals(new String[]{"${appMainClass}"},cmdl.getArguments());
assertTrue(cmdl.getExecutable().indexOf("${JAVA_HOME}") == 0);
assertEquals(new String[]{"${appMainClass}"},cmdl.getArguments());
assertTrue(cmdl.getExecutable().indexOf("${JAVA_HOME}") < 0);
assertTrue(cmdl.getExecutable().indexOf("local") > 0);
assertEquals(new String[]{"foo.bar.Main"},cmdl.getArguments());
assertTrue(cmdl.getExecutable().indexOf("${JAVA_HOME}") < 0);
assertTrue(cmdl.getExecutable().indexOf("local") > 0);
assertEquals(new String[]{"${appMainClass}"},cmdl.getArguments());
}