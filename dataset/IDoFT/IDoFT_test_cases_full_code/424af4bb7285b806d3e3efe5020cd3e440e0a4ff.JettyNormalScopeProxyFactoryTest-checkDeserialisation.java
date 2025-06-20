@Test public void checkDeserialisation() throws Exception {
  final File base=dir(new File("target/JettyNormalScopeProxyFactoryTest-" + System.nanoTime()));
  final File war=createWar(dir(new File(base,"test")),MyWrapper.class,MySessionScoped.class);
  String sessionId=null;
  FileSessionDataStore sessionDataStore=new FileSessionDataStore();
  sessionDataStore.setStoreDir(new File(base,"sessions"));
  for (  final String expected : asList("init","new")) {
    final Server jetty=new Server(0);
    Configuration.ClassList classList=Configuration.ClassList.serverDefault(jetty);
    classList.addBefore("org.eclipse.jetty.webapp.JettyWebXmlConfiguration","org.eclipse.jetty.annotations.AnnotationConfiguration",OwbConfiguration.class.getName());
    WebAppContext ctx=new WebAppContext();
    ctx.setWar(war.getAbsolutePath());
    ctx.setContextPath("/test");
    ctx.setLogUrlOnStart(true);
    ctx.setConfigurationClasses(classList);
    SessionIdManager idmanager=new DefaultSessionIdManager(jetty);
    jetty.setSessionIdManager(idmanager);
    final SessionHandler sessionHandler=new SessionHandler();
    final SessionCache sessionCache=new DefaultSessionCache(sessionHandler);
    sessionCache.setSessionDataStore(sessionDataStore);
    sessionCache.setEvictionPolicy(900);
    sessionHandler.setSessionCache(sessionCache);
    ctx.setSessionHandler(sessionHandler);
    jetty.setHandler(ctx);
    jetty.start();
    try {
      Thread thread=Thread.currentThread();
      ClassLoader old=thread.getContextClassLoader();
      final ClassLoader webappLoader=ctx.getClassLoader();
      thread.setContextClassLoader(webappLoader);
      try {
        final Class<?> webapptype=webappLoader.loadClass(MySessionScoped.class.getName());
        final Method setValue=webapptype.getMethod("setValue",String.class);
        final Method getValue=webapptype.getMethod("getValue");
        final Class<?> wrapperType=webappLoader.loadClass(MyWrapper.class.getName());
        final Method m=wrapperType.getMethod("getProxy");
        final BeanManager bm=CDI.current().getBeanManager();
        HttpChannel channel=new HttpChannel(jetty.getConnectors()[0],new HttpConfiguration(),null,null){
          @Override public Server getServer(){
            return jetty;
          }
        }
;
        Request request=new Request(channel,null);
        request.setPathInfo("/test");
        request.setContext(ctx.getServletContext());
        request.setRequestedSessionId(sessionId);
        request.setSessionHandler(ctx.getSessionHandler());
        if (sessionId != null) {
          request.setSession(ctx.getSessionHandler().getSession(sessionId));
        }
        final ContextsService contextsService=WebBeansContext.currentInstance().getContextsService();
        final ServletRequestEvent startParameter=new ServletRequestEvent(ctx.getServletContext(),request);
        contextsService.startContext(RequestScoped.class,startParameter);
        final HttpSession session=request.getSession();
        if (request.getSession() != null) {
          contextsService.startContext(SessionScoped.class,request.getSession());
        }
{
          final Object bean=m.invoke(bm.getReference(bm.resolve(bm.getBeans(wrapperType)),wrapperType,null));
          assertEquals(expected,getValue.invoke(bean));
          setValue.invoke(bean,"new");
          assertEquals("new",getValue.invoke(bean));
        }
        sessionId=session.getId();
        contextsService.endContext(RequestScoped.class,startParameter);
      }
 catch (      AssertionError e) {
        throw e;
      }
catch (      Exception e) {
        log.log(Level.SEVERE,"Exception during test execution",e);
      }
 finally {
        thread.setContextClassLoader(old);
      }
    }
  finally {
      try {
        jetty.stop();
      }
 catch (      Exception e) {
        log.log(Level.SEVERE,"This _might_ happen on Java9 currently. I hope it gets soon fixed.",e);
      }
    }
  }
}
