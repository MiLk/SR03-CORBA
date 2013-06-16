package chat;
import java.util.Date;
import java.lang.String;
import org.omg.CosNaming.*;

public class ChatServiceImpl extends ChatServicePOA
{
  public String getTheDate()
  {
    Date day = new Date();
    String date = day.toString();
    System.out.println(date);
    return date;
  }
  public void newChatRoom(String _chatroom) {
    NameComponent[] ns = new NameComponent [2];
    ns[0] = new NameComponent("ChatRooms","");
    ns[1] = new NameComponent(_chatroom,"");

    org.omg.CORBA.Object objRef = null;
    try {
      objRef = this._orb().resolve_initial_references("NameService");
    } catch(org.omg.CORBA.ORBPackage.InvalidName e) {
      e.printStackTrace();
    }
    NamingContext ncRef = NamingContextHelper.narrow(objRef);
    try {
      ncRef.bind_new_context(ns);
      System.out.println("ChatRoom " + _chatroom + " created.");
    } catch(org.omg.CosNaming.NamingContextPackage.NotFound e) {
      e.printStackTrace();
    } catch(org.omg.CosNaming.NamingContextPackage.CannotProceed e) {
      e.printStackTrace();
    } catch(org.omg.CosNaming.NamingContextPackage.InvalidName e) {
      e.printStackTrace();
    } catch(org.omg.CosNaming.NamingContextPackage.AlreadyBound e) {
      System.out.println("ChatRoom " + _chatroom + " already exists.");
    }
  }
  public void send(String _chatroom, String _msg) {
    System.out.println("[" + _chatroom + "] " + _msg);
    try {
      NameComponent[] ns = new NameComponent [2];
      ns[0] = new NameComponent("ChatRooms","");
      ns[1] = new NameComponent(_chatroom,"");

      org.omg.CORBA.Object objRef = this._orb().resolve_initial_references("NameService");
      NamingContext ncRef = NamingContextHelper.narrow(objRef);
      NamingContext nc = NamingContextHelper.narrow(ncRef.resolve(ns));

      Binding[] bl = null;
      BindingListHolder blh = new BindingListHolder();
      BindingIteratorHolder bih = new BindingIteratorHolder();
      nc.list (0, blh, bih);
      BindingIterator bi = bih.value;
      if (bi != null) {
        boolean continuer = true;
        while (continuer) {
          continuer = bi.next_n(10,blh);
          bl = blh.value;
          for (int i=0; i < bl.length; i++) {
            for(int j=0; j < bl[i].binding_name.length; ++j) { 
              NameComponent[] nsIt = new NameComponent [3];
              nsIt[0] = new NameComponent("ChatRooms","");
              nsIt[1] = new NameComponent(_chatroom,"");
              nsIt[2] = bl[i].binding_name[j];
              Chatter chatter = ChatterHelper.narrow(ncRef.resolve(nsIt));
              System.out.println("Send message to " + nsIt[2].id);
              chatter.receive(_msg);
            }
          }
        }
        bi.destroy();
      }
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

