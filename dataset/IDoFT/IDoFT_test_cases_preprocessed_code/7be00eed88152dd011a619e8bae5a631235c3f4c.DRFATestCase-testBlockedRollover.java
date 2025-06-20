/** 
 * Tests rollOver when log file is unabled to be renamed. See bug 43374.
 * @throws IOException if io error.
 * @throws InterruptedException if test interrupted while waiting for the start of the next minute.
 */
public void testBlockedRollover() throws IOException, InterruptedException {
File block1=new File(filename + new SimpleDateFormat(pattern).format(start));//RO
File block2=new File(filename + new SimpleDateFormat(pattern).format(new Date(start.getTime() + 60000)));//RO
FileOutputStream os1=new FileOutputStream(block1);
FileOutputStream os2=new FileOutputStream(block2);
Thread.sleep(63000 - (start.getTime() % 60000));
FileOutputStream combined=new FileOutputStream(combinedFilename);
append(combined,new FileInputStream(block1),buf);
append(combined,new FileInputStream(block2),buf);
append(combined,new FileInputStream(filename),buf);
assertTrue(Compare.compare(combinedFilename,"witness/drfa_blockedRollover.log"));
}