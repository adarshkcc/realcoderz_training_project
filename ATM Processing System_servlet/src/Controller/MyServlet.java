//https://cdn.hipwallpaper.com/i/18/23/8hXN0U.jpg

package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Bank;
import Model.PinValidation;
import facadePatternTransaction.copy.FacadePatternDemo;
import org.apache.*;
import org.apache.log4j.Logger;
/**
 * Servlet implementation class MyServlet
 */
//@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor. 
	 */
	public MyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		response.setContentType("text/html");
		PrintWriter ob=response.getWriter();

		final Logger LOGGER = Logger.getLogger(TestLog4jServlet.class);
		// value coming from pin.jsp 
		String g=request.getParameter("pin");

		// values coming from service.jsp
		String g1=request.getParameter("withdrawAmount");
		String g2=request.getParameter("transferAmount");
		String g3=request.getParameter("checkBalance");
		String g4=request.getParameter("transactionHistory");
		String g5=request.getParameter("exit");

		String withdrawAmount=request.getParameter("Amount");

		String transferAmount=request.getParameter("transferAmount");
		String accountNumber=request.getParameter("accountNumber");

		String exit=request.getParameter("exit");

		String Continue=request.getParameter("continue");


		if(g!=null)
		{
			try {
				Integer pin=new Integer(g);
				boolean flag = PinValidation.validatePin(pin);
				if(flag==true)
				{
					System.out.println("valid pin\n");

					//object is created to get the name of valid user
					Bank b=new Bank();
					LOGGER.info("user logged in successfully\n name:"+b.getAccountHolder());



					// it will assign the name of user and forward to the jsp page.
					System.out.println("\n"+b.getAccountHolder());
					request.setAttribute("name",b.getAccountHolder() );

					RequestDispatcher rd = request.getRequestDispatcher("service.jsp");
					rd.forward(request, response);


				}
				else
				{

					LOGGER.info("invalid pin");
					System.out.println("invalid pin");

					request.setAttribute("name",null);
					RequestDispatcher rd = request.getRequestDispatcher("pin.jsp");
					rd.forward(request, response);

					//response.sendRedirect("pin.jsp");
				}
			}
			catch(NumberFormatException e)
			{
				LOGGER.info("entered pin is in incorrect format");
				response.sendRedirect("pin.jsp");
			}
		}
		//		ob.print(g1);
		else
		{
			//String s=new String(g1);
			if(g1!=null)
			{

				RequestDispatcher rd = request.getRequestDispatcher("InputWithdrawAmount.jsp");
				rd.forward(request, response);
				//	response.sendRedirect("InputWithdrawAmount.jsp");
			}
			else if(withdrawAmount!=null)
			{
				try {

					Double Amount=new Double(withdrawAmount);

					System.out.println(Amount);
					if(Amount<=new Bank().getBalance())
					{
						LOGGER.info("amount withdrawn : "+Amount);
						double newBalance=	FacadePatternDemo.withdrawAmount1(Amount);
						request.setAttribute("amount",Amount );
						request.setAttribute("newBalance", newBalance);
						System.out.println(newBalance);
						RequestDispatcher rd = request.getRequestDispatcher("OutputWithdrawAmount.jsp");
						rd.forward(request, response);
					}
					else
					{
						request.setAttribute("name", new Bank().getAccountHolder());
						//				RequestDispatcher rd = request.getRequestDispatcher("service.jsp");
						//				rd.forward(request, response);
						LOGGER.info("entered amount is exceed i.e do not have sufficient balance to withdraw amount ");
						response.sendRedirect("service.jsp");
					}

				}
				catch(NumberFormatException e)
				{
					LOGGER.info("entered amount is not in correct format");
					LOGGER.info("Exception : NumberFormatException");

					System.out.println("enter valid Amount");
					response.sendRedirect("InputWithdrawAmount.jsp");
				}
			}

			else if(exit!=null)
			{
				LOGGER.info("exit");
				System.out.println("thanks for ur visit");
				Bank.store.clear();
				Bank.remainingBalance.clear();
				Bank.ch.clear();


				request.setAttribute("name", "valid");
				RequestDispatcher rd = request.getRequestDispatcher("pin.jsp");
				rd.forward(request, response);
				//response.sendRedirect("pin.jsp");
			}

			else if(Continue!=null)
			{
				LOGGER.info("on clicking continue button user redirected to service.jsp ");
				request.setAttribute("name", new Bank().getAccountHolder());
				RequestDispatcher rd = request.getRequestDispatcher("service.jsp");
				rd.forward(request, response);
				//	response.sendRedirect("service.jsp");
			}


			// this block is for transaction history
			else if(g4!=null)
			{
				//	System.out.println(	Bank.store.isEmpty());
				boolean b=FacadePatternDemo.transactionHistory1();
				if(b==false)
				{

					System.out.println("you Have not done any Transaction");

					request.setAttribute("WithdrawalList", Bank.store); 
					RequestDispatcher rd = request.getRequestDispatcher("TransactionHistory.jsp"); 
					rd.forward(request, response);
				}
				else
				{
					LOGGER.info("user checked transaction history");
					System.out.println("you have done some Transaction");
					request.setAttribute("WithdrawalList", Bank.store);
					request.setAttribute("remainingBalanceList", Bank.remainingBalance);
					request.setAttribute("characterList", Bank.ch);
					RequestDispatcher rd = request.getRequestDispatcher("TransactionHistory.jsp");
					rd.forward(request, response);
				}
			}

			else if((transferAmount!=null) && (accountNumber!=null))
			{
				Bank b=new Bank();

				try {
					LOGGER.info("user is on transferAmount.jsp page");
					Double amount=new Double(transferAmount);

					if(amount<=b.getBalance())
					{
						Long accountNo=new Long(accountNumber);
						double balance=	FacadePatternDemo.transferAmount1(amount,accountNo);
						double newBalance=b.getBalance()-balance;

						if(Bank.flag==false)
						{
							LOGGER.info("enterd Account no.is incorrect and amount  not transfered");
							System.out.println("Account not matched");
							response.sendRedirect("TransferAmount.jsp");
						}
						else
						{
							LOGGER.info("amount transfered : "+amount);
							System.out.println("Account matched");
							request.setAttribute("amount",amount );
							request.setAttribute("newBalance", newBalance);
							System.out.println(newBalance);
							RequestDispatcher rd = request.getRequestDispatcher("OutputTransferAmount.jsp");
							rd.forward(request, response);


						}
					}
					else {
						System.out.println("insufficient Balance");
						response.sendRedirect("TransferAmount.jsp");
					}
				}
				catch(Exception e)
				{
					LOGGER.info("Exception found");
					LOGGER.info("Enterd detailed was not in correct format");
					response.sendRedirect("TransferAmount.jsp");
				}
			}

			else if(g3!=null)
			{
				request.setAttribute("amount",new Bank().getBalance() );
				RequestDispatcher rd = request.getRequestDispatcher("checkBalance.jsp");
				rd.forward(request, response);
			}
			else if((transferAmount==null)||(accountNumber==null))
			{
				response.sendRedirect("TransferAmount.jsp");
			}



		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
