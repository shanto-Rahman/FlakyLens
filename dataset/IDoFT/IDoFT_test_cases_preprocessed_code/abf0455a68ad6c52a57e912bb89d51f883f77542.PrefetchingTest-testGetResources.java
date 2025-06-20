/** 
 * Once the jar files are cached, ClassLoader.getResources() should return jar URLs.
 */
public void testGetResources() throws Exception {
Assert.assertThat(lines[1],allOf(startsWith("jar:file:"),containsString(dir.toURI().getPath()),endsWith("::hello2")));
}