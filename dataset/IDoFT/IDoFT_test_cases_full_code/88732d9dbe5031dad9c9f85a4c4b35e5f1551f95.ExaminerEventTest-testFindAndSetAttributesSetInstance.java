@Test public void testFindAndSetAttributesSetInstance(){
  DependencyContainer.getInstance().clear();
  JavaSource javaSource;
  String sourceCode;
  javaSource=JavaSourceFactory.getInstance().newJavaSource("TunguskaGate");
  sourceCode="@WebServlet(name = \"TunguskaGate\", urlPatterns = {\"/live/*\"}, asyncSupported = true)\n" + "public class TunguskaGate extends HttpServlet {\n" + "    @Inject @SnapshotDataCollector\n"+ "    Event<BrowserWindow> events;\n"+ "    private final static Logger LOG = Logger.getLogger(TunguskaGate.class.getName());\n"+ "    @Override\n"+ "    protected void doGet(HttpServletRequest request, HttpServletResponse response)\n"+ "            throws ServletException, IOException {\n"+ "        AsyncContext startAsync = request.startAsync();\n"+ "        String channel = extractChannel(request.getRequestURI());\n"+ "        LOG.info(\"Browser is requesting \" + channel);\n"+ "        if(channel==null||channel.trim().isEmpty()){\n"+ "            channel = MonitoringController.COMBINED_SNAPSHOT_NAME;\n"+ "        }\n"+ "        BrowserWindow browser = new BrowserWindow(startAsync,channel);\n"+ "        LOG.info(\"Registering browser window(\"+ browser.hashCode() +\") for channel \" + channel);\n"+ "        events.fire(browser);\n"+ "        LOG.fine(\"Event sent\");\n"+ "    }\n"+ "    }\n";
  javaSource.setSourceCode(sourceCode);
  examiner.examine(javaSource);
  assertEquals(1,DependencyContainer.getInstance().getDependencies(javaSource).size());
  Dependency dependency;
  dependency=DependencyContainer.getInstance().getDependencies(javaSource).get(0);
  assertEquals(DependencyType.EVENT,dependency.getDependencyType());
  assertEquals("TunguskaGate",dependency.getJavaSourceFrom().getName());
  assertEquals("BrowserWindow",dependency.getJavaSourceTo().getName());
}
