@Test public void testManyMethods(){
  try {
    Guice.createInjector(new AbstractModule(){
      @Override protected void configure(){
        install(ThrowingProviderBinder.forModule(this));
      }
      @SuppressWarnings("unused") @CheckedProvides(ManyMethods.class) String foo(){
        return null;
      }
    }
);
    fail();
  }
 catch (  CreationException ce) {
    String message=Iterables.getOnlyElement(ce.getErrorMessages()).getMessage();
    List<Method> list=Arrays.asList(ManyMethods.class.getDeclaredMethods());
    List<Method> reversedList=new ArrayList<>();
    reversedList.add(list.get(1));
    reversedList.add(list.get(0));
    assertTrue((ManyMethods.class.getName() + " may not declare any new methods, but declared " + list).equals(message) || (ManyMethods.class.getName() + " may not declare any new methods, but declared " + reversedList).equals(message));
  }
}
