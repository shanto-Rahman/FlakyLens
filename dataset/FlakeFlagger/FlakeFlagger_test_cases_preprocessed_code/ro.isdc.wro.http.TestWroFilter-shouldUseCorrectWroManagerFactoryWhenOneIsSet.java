/** 
 * Test that when setting WwroManagerFactory via setter, even if wroConfiguration has a different   {@link WroManagerFactory}  configured, the first one instance is used.
 */
@Test public void shouldUseCorrectWroManagerFactoryWhenOneIsSet() throws Exception {
Assert.assertSame(managerClass,actualClass);
}