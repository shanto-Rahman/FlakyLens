@Test public void dependencyResolutionWithCustomClassLoader(){
assertEquals(0,this.groovyClassLoader.getURLs().length);
assertEquals(5,customClassLoader.getURLs().length);
}