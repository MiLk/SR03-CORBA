package chat; 

import org.omg.PortableServer.POAHelper;
import org.omg.CosNaming.*;

import java.lang.String;
import java.util.Scanner;

public class ChatClient 
{  public static void main(String args[]) 
   {  // Same as the server
      java.util.Properties props = System.getProperties(); 
      props.put("org.omg.CORBA.ORBClass", 
    		  "com.ooc.OBServer.ORB"); 
      props.put("org.omg.CORBA.ORBSingletonClass",
    		  "com.ooc.CORBA.ORBSingleton");
      
      int status = 0; 
      org.omg.CORBA.ORB orb = null; 
      try 
      {   orb = org.omg.CORBA.ORB.init(args, props); 
    	  status = run(orb); 
      } 
      catch(Exception ex) 
      {   ex.printStackTrace(); 
    	  status = 1; 
      } 
      
      if(orb != null) 
      { try 
    	{  orb.destroy(); }
    	catch(Exception ex)
    	{  ex.printStackTrace(); 
    	   status = 1;   } 
      }     
      System.exit(status);  
   } 
   
//----- run() -----
   
   static int run(org.omg.CORBA.ORB orb)
    throws org.omg.CORBA.UserException
   {
    // Initialisation du Bus Corba et d’un POA
    org.omg.PortableServer.POA poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
    poa.the_POAManager().activate();

	    try {
        org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
        org.omg.CosNaming.NamingContext ncRef = org.omg.CosNaming.NamingContextHelper.narrow(objRef);
        
        // Recuperation du ChatService
        NameComponent nc = new NameComponent("ChatService","");
        NameComponent path[] = {nc};
        ChatService service = ChatServiceHelper.narrow(ncRef.resolve(path));

        System.out.println(service.getTheDate());

        service.newChatRoom("SR03");

        // Creation du Chatter
        ChatterImpl chatter = new ChatterImpl();
        chatter._this(orb);
        chatter.subscribe("A", "SR03");

        ChatterImpl chatter2 = new ChatterImpl();
        chatter2._this(orb);
        chatter2.subscribe("B", "SR03");

        service.send("SR03","test");
      }
      catch(org.omg.CORBA.ORBPackage.InvalidName ex) 
	    {  ex.printStackTrace(); 
	       return 1; }
	    catch(org.omg.CosNaming.NamingContextPackage.NotFound ex) 
	    {  ex.printStackTrace(); 
	       return 1; }
      catch(org.omg.CosNaming.NamingContextPackage.CannotProceed ex) 
	    {  ex.printStackTrace(); 
	       return 1; }
	    catch(org.omg.CosNaming.NamingContextPackage.InvalidName ex) 
	    {  ex.printStackTrace(); 
	       return 1; }
    orb.run();
	  return 0; 
   }  
}
