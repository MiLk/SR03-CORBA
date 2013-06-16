package chat;
import java.util.Date;
import java.lang.String;
import org.omg.CosNaming.*;

public class ChatterImpl extends ChatterPOA
{
  public String getTheDate()
  {
    Date day = new Date();
    String date = day.toString();
    System.out.println(date);
    return date;
  }
  public void receive(String _msg) {
    System.out.println("Chatter receive: " + _msg);
  }
  public void subscribe(String _pseudo, String _chatroom) {
    try {
      org.omg.CORBA.Object objRef = this._orb().resolve_initial_references("NameService");
      NamingContext ncRef = NamingContextHelper.narrow(objRef);

      NameComponent[] ns = new NameComponent [3];
      ns[0] = new NameComponent("ChatRooms","");
      ns[1] = new NameComponent(_chatroom,"");
      ns[2] = new NameComponent(_pseudo,"");
      ncRef.rebind(ns, this._this_object());

    } catch(org.omg.CosNaming.NamingContextPackage.NotFound e) {
      e.printStackTrace();
    } catch(org.omg.CosNaming.NamingContextPackage.CannotProceed e) {
      e.printStackTrace();
    } catch(org.omg.CosNaming.NamingContextPackage.InvalidName e) {
      e.printStackTrace();
    } catch(org.omg.CORBA.ORBPackage.InvalidName e) {
      e.printStackTrace();
    }
  }
}

