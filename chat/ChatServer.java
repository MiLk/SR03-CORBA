package chat;

import org.omg.PortableServer.POAHelper;
import org.omg.CosNaming.NameComponent;
import java.lang.String;

public class ChatServer
{ 
  public static void main(String args[])
  { 
    java.util.Properties props = System.getProperties(); 
    props.put("org.omg.CORBA.ORBClass", 
    		"com.ooc.OBServer.ORB"); 
    props.put("org.omg.CORBA.ORBSingletonClass",
    		"com.ooc.CORBA.ORBSingleton");
    int status = 0; 
    org.omg.CORBA.ORB orb = null; 
    try 
    {
      orb = org.omg.CORBA.ORB.init(args, props); 
	    status = run(orb); 
    } 
    catch(Exception ex) 
    {
      ex.printStackTrace(); 
    	status = 1; 
    } 
    
    if(orb != null) 
    {
      try 
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
    // récupération du serveur de nom
    org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
    org.omg.CosNaming.NamingContext ncRef = org.omg.CosNaming.NamingContextHelper.narrow(objRef);

    // Creation du servant et enregistrement au serveur de noms
    ChatServiceImpl service = new ChatServiceImpl();

    NameComponent nc = new NameComponent("ChatService","");
    NameComponent path[] = {nc};
    ncRef.rebind(path, service._this(orb));

    NameComponent[] ns = new NameComponent [1];
    ns[0] = new NameComponent("ChatRooms","");
    try {
      ncRef.bind_new_context(ns);
    } catch(org.omg.CosNaming.NamingContextPackage.AlreadyBound e) {
      System.out.println("Context already bound.");
    }
	  orb.run(); 

    ncRef.unbind(ns);
	  return 0; 
   }
}
