@Test public void testProviderMethodWithManyExceptions(){
  try {
    Guice.createInjector(new AbstractModule(){
      @Override protected void configure(){
        install(ThrowingProviderBinder.forModule(this));
      }
      @SuppressWarnings("unused") @CheckedProvides(RemoteProvider.class) String foo() throws InterruptedException, RuntimeException, RemoteException, AccessException, TooManyListenersException {
        return null;
      }
    }
);
    fail();
  }
 catch (  CreationException ce) {
    List<Message> errors=ImmutableList.copyOf(ce.getErrorMessages());
    String expected1=InterruptedException.class.getName() + " is not compatible with the exceptions ([" + RemoteException.class+ "]) declared in the CheckedProvider interface ("+ RemoteProvider.class.getName()+ ")";
    String expected2=TooManyListenersException.class.getName() + " is not compatible with the exceptions ([" + RemoteException.class+ "]) declared in the CheckedProvider interface ("+ RemoteProvider.class.getName()+ ")";
    assertEquals(new HashSet(){
{
        add(expected1);
        add(expected2);
      }
    }
,new HashSet(){
{
        add(errors.get(0).getMessage());
        add(errors.get(1).getMessage());
      }
    }
);
    assertEquals(2,errors.size());
  }
}
