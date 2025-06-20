@SuppressWarnings("unchecked") @Test public void dependencyResolutionWithExclusions(){
assertEquals(3,this.groovyClassLoader.getURLs().length);
}