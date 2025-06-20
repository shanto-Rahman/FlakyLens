@Test public void checkDeserialisation() throws Exception {
  final File base=dir(new File("target/TomcatNormalScopeProxyFactoryTest-" + System.nanoTime()));
  final File war=createWar(dir(new File(base,"test")),MyWrapper.class,MySessionScoped.class);
  String sessionId=null;
  for (  final String expected : asList("init","new")) {
    final Tomcat tomcat=new Tomcat();
    tomcat.setPort(0);
    tomcat.setBaseDir(base.getAbsolutePath());
    final Context ctx=tomcat.addContext("/test",war.getAbsolutePath());
    ctx.addLifecycleListener(new ContextLifecycleListener());
    if (ctx instanceof StandardContext) {
      ((StandardContext)ctx).setClearReferencesRmiTargets(false);
    }
    tomcat.start();
    try {
      Thread thread=Thread.currentThread();
      ClassLoader old=thread.getContextClassLoader();
      final ClassLoader webappLoader=ctx.getLoader().getClassLoader();
      thread.setContextClassLoader(webappLoader);
      try {
        final Class<?> webapptype=webappLoader.loadClass(MySessionScoped.class.getName());
        final Method setValue=webapptype.getMethod("setValue",String.class);
        final Method getValue=webapptype.getMethod("getValue");
        final Class<?> wrapperType=webappLoader.loadClass(MyWrapper.class.getName());
        final Method m=wrapperType.getMethod("getProxy");
        final BeanManager bm=CDI.current().getBeanManager();
        final Response response=new Response();
        response.setConnector(tomcat.getConnector());
        response.setCoyoteResponse(new org.apache.coyote.Response());
        final Request request=new Request();
        request.setContext(ctx);
        request.setResponse(response);
        request.setRequestedSessionId(sessionId);
        final ContextsService contextsService=WebBeansContext.currentInstance().getContextsService();
        final ServletRequestEvent startParameter=new ServletRequestEvent(ctx.getServletContext(),request);
        contextsService.startContext(RequestScoped.class,startParameter);
        if (request.getSession() != null) {
          contextsService.startContext(SessionScoped.class,request.getSession());
        }
{
          final Object bean=m.invoke(bm.getReference(bm.resolve(bm.getBeans(wrapperType)),wrapperType,null));
          assertEquals(expected,getValue.invoke(bean));
          setValue.invoke(bean,"new");
          assertEquals("new",getValue.invoke(bean));
        }
        sessionId=request.getSession().getId();
        contextsService.endContext(RequestScoped.class,startParameter);
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
        tomcat.stop();
      }
 catch (      Exception e) {
        log.log(Level.SEVERE,"This _might_ happen on Java9 currently. I hope it gets soon fixed.",e);
      }
    }
  }
}
