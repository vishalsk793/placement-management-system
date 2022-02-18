
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;



public class Placement 
{

      public static void main(String[] args) 
             {
		// TODO Auto-generated method stub
		
		
        System.out.println("*******************************************************************************");
        System.out.println("*                                                                             *");
        System.out.println("*                                                                             *");
        System.out.println("*                             KLE BCA COLLEGE HUBLI                           *");
        System.out.println("*               PROJECT ON PLACEMENT OFFICER TO COLLECT STUDENT DATA          *");
        System.out.println("*                     PROJECT SUBMITTED BY : VISHAL.S.KHATAVKAR               *");
        System.out.println("*                     UNDER THE GUICENCE OF: BASAVARAJ SIR                    *");
        System.out.println("*                     ROLL NO              : 217149                           *");
        System.out.println("*                                                                             *");
        System.out.println("*                                                                             *");
        System.out.println("*                                                                             *");
        System.out.println("*                                                                             *");
        System.out.println("*******************************************************************************");
	System.out.println("PRESS ANY KEY                                                                  ");
		Scanner in = new Scanner(System.in);
		in.nextLine();
		
		   while(true)
	        {
	    		System.out.println("1.Login \t 2.Exit");
	    		
	        	String str = in.nextLine();
	        	if(Integer.parseInt(str) == 2)
                        {
	        		System.exit(0);
	        	}
	        	
	        	 switch(Integer.parseInt(str)) 
			        {
			          case 1: 
		            	    try
                                      {
		            		BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in)); 
			                
		            		System.out.println("enter Staff_Id");
			                String username=reader.readLine();
			                
			                
			                System.out.println("enter password");
			                String pwd= reader.readLine();
			                
			                if(username.equalsIgnoreCase("admin") && pwd.equalsIgnoreCase("admin"))
                                            {
			                	
			                	while(true)
                                                    {
			                		System.out.println("\n\n\n\n");
			                		System.out.println("1.Add Student Details");
			                		System.out.println("2.To Search Student Record");
			                		System.out.println("3.Report on Company Joined");
			                		System.out.println("4. Report on College Name");
			                		System.out.println("5.List All Student");
			                		System.out.println("6. Logout");
				                	String option = in.nextLine();
				                	int opt=0;
				                	switch(Integer.parseInt(option))
                                                            {
				                		case 1:
				                			try
                                                                           {
					 		            		
					 		            		BufferedReader reader1 =  new BufferedReader(new InputStreamReader(System.in)); 
					 			                
					 		            		System.out.println("Enter roll No");
					 		            		String rolln=reader1.readLine();
					 		            		
					 		            		System.out.println("Enter name");
					 			                String name=reader1.readLine();
					 			                
					 			               System.out.println("Enter percentage");
					 			                String percentage=reader1.readLine();
					 			                
					 			               System.out.println("Enter College Name");
					 			                String college_name= reader1.readLine();
					 			              
					 			                
					 			               System.out.println("Enter No of Companies Applied");
					 			                String no_compaines_applied=reader1.readLine();
					 			                
					 			               System.out.println("Enter no of companies Selected");
					 			                String no_of_companies_selected=reader1.readLine();
					 			                
					 			               System.out.println("Enter joined company name");
					 			                String joined_company_name=reader1.readLine();
					 			                
					 			                
					 			                
					 			                DataSource ds=new DataSource();
					 			                
					 			                ds.writeData(Integer.parseInt(rolln), name, Float.parseFloat(percentage), college_name, Integer.parseInt(no_compaines_applied), Integer.parseInt(no_of_companies_selected), joined_company_name);
					 			                
					 			                for(int i=0;i<Integer.parseInt(no_of_companies_selected); i++){
					 			                	System.out.println("Enter selected Companies name :");
					 			                	String Comp_name=reader1.readLine();
					 			                	ds.write_company_data(Integer.parseInt(rolln), Comp_name);
					 			                }
					 			                break;
					 			                
					 			               
					 		            	}
                                                                       catch(Exception e)
                                                                        {
					 		            		System.out.println(e.getMessage());
					 		            	}
				                			 break;
				                		
				                		case 2:
				                			try
                                                                            {
				                				
				                				BufferedReader reader1 =  new BufferedReader(new InputStreamReader(System.in)); 
					 			                
					 		            		System.out.println("enter roll No To Search");
					 		            		String rollno=reader1.readLine();
					 		            		
					 		            		DataSource ds2=new DataSource();
					 		            		ds2.searchData(Integer.parseInt(rollno));
					 		            		ds2.searchCompanyData(Integer.parseInt(rollno));
				                			    }
                                                                       catch(Exception e)
                                                                        {
				                				e.printStackTrace();
				                			}
				                			
				                			break;
				                			
				                		case 3:
				                			try{
				                				BufferedReader reader2 =  new BufferedReader(new InputStreamReader(System.in)); 
					 			                
					 		            		System.out.println("enter company name");
					 		            		String comp_name=reader2.readLine();
					 		            		
					 		            		DataSource ds3=new DataSource();
					 		            		ds3.companyReport(comp_name);
					 		            		
				                			}catch(Exception e){
				                				e.printStackTrace();
				                			}
				                			break;
				                			
				                		case 4:
				                			try{
				                				BufferedReader reader2 =  new BufferedReader(new InputStreamReader(System.in)); 
					 			                
					 		            		System.out.println("enter college name");
					 		            		String college_name=reader2.readLine();
					 		            		
					 		            		DataSource ds3=new DataSource();
					 		            		ds3.collegeReport(college_name);
					 		            		
				                			}catch(Exception e){
				                				e.printStackTrace();
				                			}
				                			break;
				                			
				                		case 5:
				                			try{
				                				DataSource ds3=new DataSource();
					 		            		ds3.listAllStudents();
					 		            		
				                			}catch(Exception e){
				                				e.printStackTrace();
				                			}
				                			break;
				                		case 6:
				                			opt=6;
				 			                	break;
					 		            	
				                	}
				                	if(opt == 6){
				                		break;
				                	}
			                	}
				                
			                }else{
			                	System.out.println("Invalid Login Credientials Try Again");
			                }
		            	}catch(Exception e){
		            		System.out.println("Exception Occured"+e.getMessage());
		            	}
		            	
		            	break;
			        
			        }
	        }
	}

}
