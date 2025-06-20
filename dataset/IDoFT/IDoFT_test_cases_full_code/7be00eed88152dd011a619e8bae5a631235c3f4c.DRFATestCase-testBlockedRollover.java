/** 
 * Tests rollOver when log file is unabled to be renamed. See bug 43374.
 * @throws IOException if io error.
 * @throws InterruptedException if test interrupted while waiting for the start of the next minute.
 */
public void testBlockedRollover() throws IOException, InterruptedException {
  Layout layout=new SimpleLayout();
  String filename="output/drfa_blockedRollover.log";
  String pattern="'.'yyyy-MM-dd-HH-mm";
  Date start=new Date();
  DailyRollingFileAppender appender=new DailyRollingFileAppender(layout,filename,pattern);
  appender.setAppend(false);
  Logger root=Logger.getRootLogger();
  root.addAppender(appender);
  File block1=new File(filename + new SimpleDateFormat(pattern).format(start));
  File block2=new File(filename + new SimpleDateFormat(pattern).format(new Date(start.getTime() + 60000)));
  FileOutputStream os1=new FileOutputStream(block1);
  FileOutputStream os2=new FileOutputStream(block2);
  root.info("Prior to rollover");
  Thread.sleep(63000 - (start.getTime() % 60000));
  root.info("Rollover attempt while blocked");
  os1.close();
  os2.close();
  root.info("Message after block removed");
  appender.close();
  String combinedFilename="output/drfa_blockedRollover.combined";
  FileOutputStream combined=new FileOutputStream(combinedFilename);
  byte[] buf=new byte[500];
  append(combined,new FileInputStream(block1),buf);
  append(combined,new FileInputStream(block2),buf);
  append(combined,new FileInputStream(filename),buf);
  combined.close();
  assertTrue(Compare.compare(combinedFilename,"witness/drfa_blockedRollover.log"));
}
