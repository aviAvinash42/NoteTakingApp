package come.servlets;
import com.entities.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helper.FactoryProvider;


public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			int noteId=Integer.parseInt(request.getParameter("noteId").trim());
			
			
			
			Session s=FactoryProvider.getFactory().openSession();
			Transaction tx=s.beginTransaction();
			
			
			Note note=(Note)s.get(Note.class, noteId);
			
			note.setTitle(title);
			note.setContent(content);
			note.setAddedDate(null);
			
			
			tx.commit();
			s.close();
			
			
			response.sendRedirect("all_all_notes.jsp");
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		
		}
	}

}
