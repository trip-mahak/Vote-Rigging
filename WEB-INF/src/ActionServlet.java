import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ActionServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		
		String name= request.getParameter("name");
		String password = request.getParameter("passwd");
		String nextPage="index.html";
		if(name.compareTo("admin")!=0 || password.compareTo("1234")!=0){
		
			
			request.getRequestDispatcher(nextPage).forward(request,response);
		}
		else{
			//request.getRequestDispatcher("next.jsp").forward(request,response);
	/*		int ch; 
  
        // check if File exists or not 
        FileReader fr=null; 
        try
        { 
            fr = new FileReader("C://Frauds.txt"); 
        } 
        catch (FileNotFoundException fe) 
        { 
            System.out.println("File not found"); 
        } 
			
			String x="";
        // read from FileReader till the end of file 
        while ((ch=fr.read())!=-1) 
            x=x+ch; 
  
        // close the file 
        fr.close(); 
		
		
			System.out.println(x);
		
		
	*/
		try{
			File file = new File("C://Frauds.txt"); 
  
  BufferedReader br = new BufferedReader(new FileReader(file)); 
  
  String st,temp=""; 
  while ((st = br.readLine()) != null) 
			{temp=temp+st+"\n,";
    System.out.println(st); }
	request.setAttribute("data",temp);
		
		}catch(Exception e){e.printStackTrace();}
		request.getRequestDispatcher("next.jsp").forward(request,response);
		}

	}
}