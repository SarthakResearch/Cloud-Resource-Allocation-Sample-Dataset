import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ImportDataset {
	public static void importTaskDataset() {
		String taskDataFile = "TaskDataset200.csv";
			String taskDataLine="";	// to read the data file line by line
			String csvSplitBy=",";
			try(BufferedReader br = new BufferedReader(new FileReader(taskDataFile))){
				boolean isFirstTaskRow=true;
				while((taskDataLine = br.readLine())!=null){	
					if(isFirstTaskRow) {
						isFirstTaskRow=false;
						continue;		//skip the first row of headings
					}
					String[] taskData = taskDataLine.split(csvSplitBy);  
					int taskId = Integer.parseInt(taskData[0]);	
					int taskLength = Integer.parseInt(taskData[1]);
					int taskBudget = Integer.parseInt(taskData[2]);
					int taskDeadline = Integer.parseInt(taskData[3]);
					char preference = taskData[4].charAt(0);

					
					AuctionMain.taskList.add(new AuctionTask(taskId, taskLength, taskBudget, taskDeadline, preference));
					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	public static void importVmDataset() {
		String vmDataFile = "150VmDataset.csv";
		String vmDataLine="";	// to read the data file line by line
		String csvSplitBy=",";	// to take comma separated values
		try(BufferedReader br = new BufferedReader(new FileReader(vmDataFile))){
			boolean isFirstVmRow=true;
			while((vmDataLine = br.readLine())!=null){	
				if(isFirstVmRow) {
					isFirstVmRow=false;
					continue;		//skip the first row of headings
				}
				String[] vmData = vmDataLine.split(csvSplitBy);  //to store the comma separated values in an array
				int vmId = Integer.parseInt(vmData[0]);		//extracting and parsing vmID as integer
				int vmMips = Integer.parseInt(vmData[1]);	//extracting and parsing vmMips as integer
				double vmRate = Double.parseDouble(vmData[2]);	//extracting and parsing vmRate as double
				double rep = Double.parseDouble(vmData[3]);
				AuctionMain.vmList.add(new AuctionVM(vmId, vmMips, vmRate, rep));	//adding data to the vmList
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
