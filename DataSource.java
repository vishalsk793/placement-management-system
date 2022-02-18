
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class DataSource {

	public void checkFileExist(String dataSource){
		
		try{
			File f = new File(dataSource);
			boolean bool=f.exists();
			if(bool == false){
				f.createNewFile();
			}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		
	}
	
	

	public int writeData(int rollNo, String name, float percentage, String college, int no_of_comp_app, int no_of_com_sel, String comapny_joined){
		try {
			
				BufferedWriter writer = new BufferedWriter(new FileWriter("./placement_student_records.txt",true));
				
				writer.write(rollNo+","+name+","+percentage+","+college+","+no_of_comp_app+","+no_of_com_sel+","+comapny_joined);
				
				writer.newLine();
				writer.close();
				
				
				
				
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return 0;
	}
 
  
	
	public void searchData(int rollNo){
		try {
			
				BufferedReader reader = new BufferedReader(new FileReader("./placement_student_records.txt"));
				
				String line=reader.readLine();
				int flag=0;
				while(line!= null){
					//System.out.println(line);
					String[] tokens=line.split(",");
					//System.out.println("tokens length :"+tokens.length);
					if(tokens.length == 7){
						
						if(Integer.parseInt(tokens[0]) == rollNo){
							
							System.out.println("Roll No :"+tokens[0]);
							System.out.println("Name    :"+tokens[1]);
							System.out.println("Percentage:"+tokens[2]);
							System.out.println("College :"+tokens[3]);
							System.out.println("No of Companies Applied :"+tokens[4]);
							System.out.println("No of Companies Selected :"+tokens[5]);
							System.out.println("Company Joined :"+tokens[6]);
							
							
							flag =1;
							break;
						}
					
					}
					line=reader.readLine();
				}
				
				if(flag == 0){
					System.out.println("Data Not Found......");
				}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
 
 
	public void companyReport(String company_name){
		try{
		HashMap<String, Integer> hash_map = new HashMap<String, Integer>();  
		BufferedReader reader = new BufferedReader(new FileReader("./placement_student_records.txt"));
		
		String line = reader.readLine();
		//System.out.println(line);
		while (line != null) {
			//System.out.println(line);
			String[] tokens=line.split(",");
			
			if(tokens.length == 7){
				if(tokens[6].equalsIgnoreCase(company_name)){
					if(hash_map.containsKey(tokens[3])){
						
						Integer value=hash_map.get(tokens[3]);
						Integer new_value=value+1;
						hash_map.put(tokens[3], new_value);
						
					}else{
						hash_map.put(tokens[3], 1);
					}
				
				}
			}
			line = reader.readLine();
		}
		reader.close();
		
		for (HashMap.Entry<String,Integer> entry : hash_map.entrySet()) {
		    System.out.println(entry.getKey() + " = " + entry.getValue());
		}
		}catch(Exception e){
			System.out.println("Exception occured");
		}
		
	 }


	
	public void collegeReport(String college_name){
		try{
		HashMap<String, Integer> hash_map = new HashMap<String, Integer>();  
		BufferedReader reader = new BufferedReader(new FileReader("./placement_student_records.txt"));
		
		String line = reader.readLine();
		
		System.out.println("Roll No|Name   |Percentage| college  | No of Comp Applied |No of Comp Selected|Company Joined");
		while (line != null) {
			
			String[] tokens=line.split(",");
			
			if(tokens.length == 7){
				if(tokens[3].equalsIgnoreCase(college_name)){
					
					System.out.println(tokens[0]+"\t"+tokens[1]+"\t"+tokens[2]+"\t"+tokens[3]+"\t"+tokens[4]+"\t"+tokens[5]+"\t"+tokens[6]);
				
				}
			}
			line = reader.readLine();
		}
		reader.close();
		
		for (HashMap.Entry<String,Integer> entry : hash_map.entrySet()) {
		    System.out.println(entry.getKey() + " = " + entry.getValue());
		}
		}catch(Exception e){
			System.out.println("Exception occured");
		}
		
	 }

	
	
	public void listAllStudents(){
		try{
		BufferedReader reader3 = new BufferedReader(new FileReader("./placement_student_records.txt"));
		
		String line = reader3.readLine();
		
		while (line != null) {
			
			String[] tokens=line.split(",");
			
			if(tokens.length == 7){
				
					
				System.out.println(tokens[0]+"\t"+tokens[1]+"\t"+tokens[2]+"\t"+tokens[3]+"\t"+tokens[4]+"\t"+tokens[5]+"\t"+tokens[6]);
				
			
			}
			line = reader3.readLine();
		}
		reader3.close();
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
int write_company_data(int rollNo, String Comp_name){
	try{
		checkFileExist("./student_company_selected_records.txt");
		BufferedWriter writer1 = new BufferedWriter(new FileWriter("./student_company_selected_records.txt",true));
		
		
		writer1.write(rollNo+","+Comp_name);
		writer1.newLine();
	
		writer1.close();
		
		
	}catch(Exception e){
		System.out.println(e.getMessage());
	}
	
	return 0;
}


public void searchCompanyData(int rollNo){
	try {
		
			BufferedReader reader = new BufferedReader(new FileReader("./student_company_selected_records.txt"));
			
			String line=reader.readLine();
			//System.out.println(line);
			System.out.println("List of Companies Selected ");
			while(line!= null){
				
				String[] tokens=line.split(",");
				
				if(tokens.length == 2){
					
					if(Integer.parseInt(tokens[0]) == rollNo){
							
						System.out.println(tokens[1]);
						
					}
				
				}
				line=reader.readLine();
			}
			
			
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	
	
}

	
}



